package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.genes.db.GenesDao;

public class Model {
	
	private Graph<String,DefaultWeightedEdge> grafo;
	private GenesDao dao;
	
	public Model() {
		dao = new GenesDao();
	}
	
	public String creaGrafo() {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, this.dao.getvertici());
		
		for(Coppia c: this.dao.getArchi() ) {
			Graphs.addEdgeWithVertices(this.grafo, c.getL1(), c.getL2(), c.getPeso());
		}
		
		return "Il grafo ha "+this.grafo.vertexSet().size()+" vertici e " +this.grafo.edgeSet().size()+" archi";
	}
	
	
	
	public List<String> getvertici(){
		return new ArrayList<>(this.grafo.vertexSet());
	}
	
	
	public List<Connessa> getStatistica(String l ){
		List<Connessa> result = new ArrayList<>();
		
		List<String> vicini = Graphs.neighborListOf(grafo, l);
		for(String s : vicini) {
			result.add(new Connessa(s,(int) grafo.getEdgeWeight(grafo.getEdge(s, l))));
		}
		return result;
	}
	
	
	public List<Coppia> getArchi(){
		List<Coppia > result = new ArrayList<>();
		for(Coppia c: this.dao.getArchi()) {
			result.add(c);
		}
		return result;
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	private GenesDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new GenesDao();
		
	}
	
	
	public List<String> getLocalization(){
		return dao.getAllLocalization();
	}
	
	public void creaGrafo() {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		// aggiungi i vertici
		
		Graphs.addAllVertices(grafo, dao.getAllLocalization());
		
		System.out.println("#VERTICI:  "+ grafo.vertexSet().size());
		
		//aggiungi archi
		for(Coppia c : this.dao.getArchi()) {
			Graphs.addEdgeWithVertices(grafo, c.getL1() , c.getL2(), c.getPeso());
			
		}
		System.out.println(String.format("#ARCHI: %d", this.grafo.edgeSet().size()));
	
		
	}
	public int nVertici(){
		return this.grafo.vertexSet().size();
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<String> getAdaicenza(String l1){
		
		List<String> adiacenza = new ArrayList<>();
		//List<String> c = new ArrayList<>();
		ConnectivityInspector<String, DefaultWeightedEdge> ci = new  ConnectivityInspector<>(this.grafo);
		adiacenza.addAll(ci.connectedSetOf(l1));
		
		return adiacenza;
	}
	
	public List<Coppia> getArchi(){
		return new ArrayList<>(this.dao.getArchi());
	}
	*/
}
