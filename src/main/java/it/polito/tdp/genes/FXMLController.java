package it.polito.tdp.genes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.genes.model.Connessa;
import it.polito.tdp.genes.model.Coppia;
import it.polito.tdp.genes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStatistiche;

    @FXML
    private Button btnRicerca;

    @FXML
    private ComboBox<String> boxLocalizzazione;

    @FXML
    private TextArea txtResult;

    @FXML
    void doRicerca(ActionEvent event) {

    }

    @FXML
    void doStatistiche(ActionEvent event) {

   
    	txtResult.clear();
    	String l = this.boxLocalizzazione.getValue();
    	
    	List<Connessa> lista = this.model.getStatistica(l);
    	
    	txtResult.appendText("Statistica:\n"+lista);
    	
    	
    	
    	/*txtResult.clear();
    	String li = this.boxLocalizzazione.getValue();
    	List<String> adiacenza = this.model.getAdaicenza(li);
    	
    	
    	
    		for(Coppia d:  model.getArchi()) {
    			if(d.getL1().equals(li)) {
    				Coppia coppia = new Coppia(li, adiacenza.toString(), d.getPeso());
    				txtResult.appendText(coppia.getL2()+"      "+ coppia.getPeso());
    				
    			}
    		}
    	
    	*/
    }

    @FXML
    void initialize() {
        assert btnStatistiche != null : "fx:id=\"btnStatistiche\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxLocalizzazione != null : "fx:id=\"boxLocalizzazione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
	
		this.model = model;
		
		String m = this.model.creaGrafo();
		txtResult.appendText(m);
		
		
		this.boxLocalizzazione.getItems().clear();
		this.boxLocalizzazione.getItems().addAll(this.model.getvertici());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	
		
		boxLocalizzazione.getItems().clear();
		boxLocalizzazione.getItems().addAll(this.model.getLocalization());
		
		model.creaGrafo();
		txtResult.clear();
		txtResult.appendText("Grafo Creato!! \n");
		txtResult.appendText("#VERTICI: "+ this.model.nVertici() + "\n");
    	txtResult.appendText("#ARCHI: " +this.model.nArchi()+"\n");
*/
	}
	
}
