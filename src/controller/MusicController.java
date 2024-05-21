package controller;

import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Music;
import model.MusicGenre;
import service.MusicService;

public class MusicController {
    @FXML
    public ListView<Music> musicListView;

    @FXML
    public Button adfdfddBtn;

    @FXML
    public Button editBtn;

    @FXML
    public Button removeBtn;

    @FXML
    public TextField songTxIDDD;

    @FXML
    public TextField artistTxIDDD;
    
    @FXML
    private ComboBox<MusicGenre> genreComboBox;
    
    @FXML
    public Button sortBtn;

    private ObservableList<Music> musicList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        MusicService musicService = new MusicService();
        List<Music> allMusic = musicService.getAllMusic();
        
        musicList.setAll(allMusic);
        musicListView.setItems(musicList);
        
        //System.out.println(allMusic);
        //musicListView.setItems(FXCollections.observableArrayList(new ArrayList<Music>(allMusic)));
        genreComboBox.setItems(FXCollections.observableArrayList(MusicGenre.values()));
        sortBtn.setOnAction(event -> onSortButtonClick(event));
    }

    @FXML
    private void onAddButtonClick(ActionEvent event) {
        Music music = new Music();
        music.setSong(songTxIDDD.getText());
        music.setArtist(artistTxIDDD.getText());
        music.setGenre(genreComboBox.getValue().name());// Utilizarea valorii selectate dintr-un combobox
        String song = music.getSong();
        if(MusicValidator.isValidSong(song)) {
        	MusicService service = new MusicService();
        	service.addMusic(music);
        	System.out.println("added: " + music);
        	System.out.println(service.getAllMusic());
        	musicList.setAll(service.getAllMusic());
        } else {
        	System.out.println("INVALID INPUT");
        }
    }

    @FXML
    private void onEditButtonClick(ActionEvent event) {
        Music selectedItem = musicListView.getSelectionModel().getSelectedItem();
        System.out.println("edit: " + selectedItem);
        if(selectedItem != null) {
           selectedItem.setSong(songTxIDDD.getText());
           selectedItem.setArtist(artistTxIDDD.getText());
           selectedItem.setGenre(genreComboBox.getValue().name());// Utilizarea valorii selectate dintr-un combobox
           String song = selectedItem.getSong();
           if(MusicValidator.isValidSong(song)) {
        	   MusicService service = new MusicService();
        	   service.updateMusic(selectedItem);
        	   System.out.println(service.getAllMusic());
        	   musicList.setAll(service.getAllMusic());
           } else {
        	   System.out.println("INVALID INPUT");
           }
        }
    }

    @FXML
    private void onRemoveButtonClick(ActionEvent event) {
         Music selectedItem = musicListView.getSelectionModel().getSelectedItem();
         if(selectedItem != null) {
            MusicService service = new MusicService();
            service.removeMusic(selectedItem);
            System.out.println("removed: " + selectedItem);
            System.out.println(service.getAllMusic());
            musicList.setAll(service.getAllMusic());
         }
    }

    @FXML
    private void onSortButtonClick(ActionEvent event) {
    	Collections.sort(musicList);
    }
}