package br.imd.ufrn.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import br.imd.ufrn.model.CsvReader;
import br.imd.ufrn.model.LinkSearcher;
import br.imd.ufrn.model.News;
import br.imd.ufrn.model.NewsDatabase;
import br.imd.ufrn.model.WebScrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SimiController {

    @FXML
    private Slider simiSlider;

    @FXML
    private Label simiSliderValue;

    @FXML
    private ListView<String> linkListView;

    @FXML
    private ListView<String> simiNews;

    @FXML
    private Label newsNumber;

    @FXML
    private TextField csvTextField;

    @FXML
    private TextField siteTextField;
    
    private NewsDatabase newsDatabase;
    private ArrayList<String> newsLinks;
    private ArrayList<String> similarNewsLinks;
    private WebScrapper scrapper; 
    
    @FXML
    void init(ActionEvent event) {
    	
    }
    
    public SimiController() {
    	newsDatabase = new NewsDatabase();
    	newsLinks = new ArrayList<String>();
    	similarNewsLinks = new ArrayList<String>();
    	
    }
    
    public void readCsv() {
    	newsDatabase = new NewsDatabase();
    	
    	try {
			CsvReader reader = new CsvReader(csvTextField.getText());
			ArrayList<String> campos;
			int intNewsNumber = 0;
			
			do {
				campos = reader.getNextRecord();
				String newsText = treatCsvLine(campos);
				
				News noticia = new News(newsText, null, null);
				newsDatabase.addNews(noticia);
				
				System.out.println(newsText);
				System.out.println();
				
				intNewsNumber++;
				newsNumber.setText(Integer.toString(intNewsNumber));
				
				Thread.sleep(2);
				
			}while(campos.size() > 0);
			
			//Verificação do armazenamento das notícias no banco de dados
			
//				System.out.println("------------------------------------");
//				System.out.println("Todas as notícias do banco de dados:");
//				System.out.println("------------------------------------");
//				Thread.sleep(5000);
//				for(News n : database.getNews()) {
//					System.out.println(n.getTexto());
//					Thread.sleep(2);
//				}
//			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    private String treatCsvLine(ArrayList<String> csvLine) {
    	String newsText = "";
    	for(int i=1; i<csvLine.size()-2; i++) {
    		if(i!=1) {
    			newsText += ",";
    		}
    		newsText += csvLine.get(i);
    	}
		return newsText;
    	
    }
    
    public void addNewsLink() {
    	
    	newsLinks.add(siteTextField.getText());
    	ObservableList<String> names = FXCollections.observableArrayList(newsLinks);
    	linkListView.setItems(FXCollections.observableArrayList(names));
    	
    }
    
    public void updateSliderCounter() {
    	simiSliderValue.setText(  String.format("%.2f",simiSlider.getValue()) );
    }
    
    public void analisarNews() {
    	double minSimilarity = simiSlider.getValue()/100;
    	similarNewsLinks = new ArrayList<String>();
    	ObservableList<String> similarLinks = FXCollections.observableArrayList(similarNewsLinks);
    	simiNews.setItems(FXCollections.observableArrayList(similarLinks));
    	
    	for(String link : newsLinks) {
    		try {
				scrapper = new WebScrapper(link);
				ArrayList<String> paragraphs = scrapper.getParagraphs();
	    		for(String p : paragraphs) {
	    			if(p.length() < 300) {
	    				continue;
	    			}
	    			News linkNews = new News( p, link, null);
	    			double firstFindSimilarity = newsDatabase.firstSimilarLeveinshtein(linkNews, minSimilarity);
	    			System.out.println("Similaridade maxima encontrada: " + firstFindSimilarity + " | Texto analisado:" + p);
	    			
	    			
	    			if(firstFindSimilarity >= minSimilarity) {
	            		similarNewsLinks.add( String.format("%.8f", firstFindSimilarity) + " | " + linkNews.getUrl() );
	            		similarLinks = FXCollections.observableArrayList(similarNewsLinks);
	                	simiNews.setItems(FXCollections.observableArrayList(similarLinks));
	                	return;
	            	}
	    			
	    		}
	    		
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}
    }
    
    public void buscaAutomatica() {
    	ArrayList<News> news = newsDatabase.getNews();
    	ArrayList<String> cachorro = new ArrayList<String>();
    	for(int i = 0; i < 2 && i < news.size(); i++) {
    		cachorro.addAll(LinkSearcher.getLinkSearchResults( LinkSearcher.shortenText( news.get(i).getTexto() ) ));
    	}
    	
    	newsLinks.addAll(cachorro);
    	ObservableList<String> names = FXCollections.observableArrayList(newsLinks);
    	linkListView.setItems(FXCollections.observableArrayList(names));
    	
    	
    }

}

