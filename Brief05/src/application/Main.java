package application;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;

import jaco.mp3.player.MP3Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;

public class Main extends Application {
	
	//static Scene panel;
	static ArrayList<ToggleGroup> listeButtonGroup;
	static Players player1;
	static Label lapelTime = new Label();
	static String chemin;
	static int cpt=0;
	static Button btn_valider;
	static Label lapel_score;
	static int tentative;
	static Group panel;
	static ArrayList<Quiz> listeQuiz ;
	static ArrayList<Player_QUIZ> listePlayer_QUIZ;
	static Timeline timeline;
	static MP3Player music;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			listeButtonGroup = new ArrayList<ToggleGroup>();
			listeQuiz = new ArrayList<Quiz>();
			listePlayer_QUIZ = new ArrayList<Player_QUIZ>();
			
			panel = new Group();
			Scene scene = new Scene(panel,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			login();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

	public static void login() {
		
		playerMusic("quiz-show.mp3");
		
		Label label_nom = new Label("nom");
		label_nom.relocate(30, 30);
		panel.getChildren().add(label_nom);
		
		Label label_prenom = new Label("prenom");
		label_prenom.relocate(30, 70);
		panel.getChildren().add(label_prenom);
		
		Label label_age = new Label("age");
		label_age.relocate(30, 110);
		panel.getChildren().add(label_age);
		
		TextField txt_nom = new TextField();
		txt_nom.relocate(90, 30);
		panel.getChildren().add(txt_nom);
		
		TextField txt_prenom = new TextField();
		txt_prenom.relocate(90, 70);
		panel.getChildren().add(txt_prenom);
		
		TextField txt_age = new TextField();
		txt_age.relocate(90, 110);
		panel.getChildren().add(txt_age);
		
		Button btn_debut = new Button("démarrer le quiz");
		btn_debut.relocate(80, 150);
		panel.getChildren().add(btn_debut);
		btn_debut.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				player1 = new Players(txt_nom.getText(), txt_prenom.getText(), Integer.parseInt(txt_age.getText()));
				
				timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(player1.getDuration() > 0) {
                            player1.setDuration(player1.getDuration()-1);
                            lapelTime.setText(LocalTime.MIN.plusSeconds(player1.getDuration()).toString());
                        }
                        else {
                            timeline.stop();
                            Dialogue("bla", "GAME OVER");
                            System.exit(0);
                        }
                    }
                }));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();

        		playerMusic("timeTicking.mp3");
                
				niveau1();
			}
		});
	}
	
	public static void niveau1() {
		Quiz quiz1 = new Quiz("JAVA est  un langage", "Compilé et interpreté", "Compilé", "Interprété", "Compilé et interpreté");
		Quiz quiz2 = new Quiz("Toutes les classes héritent de la classe", "Object", "Main", "Object", "AWT");
		Quiz quiz3 = new Quiz("Par convention une classe", "commence par une majuscule", "est en minuscule", "commence par une majuscule", "est en majuscules");
		Quiz quiz4 = new Quiz("Est-ce que on peut avoir plusieurs constructeurs pour la même classe", "oui", "oui", "non");
		Quiz quiz5 = new Quiz("Dans la ligne \"public class A implements B\", B est:", "Interfacce", "Interfacce", "Classe parent", "Package");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(1);
		

		btn_valider = new Button("valider");
		btn_valider.relocate(650, 500);
		panel.getChildren().add(btn_valider);
		btn_valider.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(checkReponseAllQuestion(1)) {
					Tentative(1);
				}
				else {
					Dialogue(null, "Merci de répondre à toutes les questions");
				}
			}
		});
	}
	public static void niveau2() {
		Quiz quiz1 = new Quiz("Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode. Quelle est l’extension du programme en bytecode ?", ".Class", "aucun des choix", ".JAVA", ".Class");
		Quiz quiz2 = new Quiz("Class Test{Public Test () {System.out.println(”Bonjour”);}public Test (int i) {this(); System.out.println(”Nous sommes en ”+i+”!”);}; }qu’affichera l’instruction suivante? Test t1=new Test (2020);", "Bonjour Nous sommes en 2020 !", "aucun des choix", "Bonjour Nous sommes en 2020 !", "Nous sommes en 2020 !");
		Quiz quiz3 = new Quiz("Voici un constructeur de la classe Employee, y-a-t'il un problème Public void Employe(String n){Nom=n;}", "vrai", "vrai", "faux");
		Quiz quiz4 = new Quiz("Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration, on la déclare comme une constante avec le mot réservé", "final", "aucun des choix", "final","const");
		Quiz quiz5 = new Quiz("Dans une classe, on accède à ses variables grâce au mot clé", "this", "aucun des choix", "this", "super");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(2);
		

		btn_valider = new Button("valider");
		btn_valider.relocate(650, 500);
		panel.getChildren().add(btn_valider);
		btn_valider.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(checkReponseAllQuestion(1)) {
					Tentative(1);
				}
				else {
					Dialogue(null, "Merci de répondre à toutes les questions");
				}
			}
		});
	}
	public static void niveau3() {
		Quiz quiz1 = new Quiz("calculerSalaire(int) calculerSalaire(int, double)La méthode calculerSalaire est:", "surchargée", "aucun des choix", "surchargée", "redéfinie");
		Quiz quiz2 = new Quiz("Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.", "vrai", "vrai", "faux");
		Quiz quiz3 = new Quiz("Est-ce qu’une classe peut implémenter plusieurs interfaces?", "vrai", "vrai", "faux");
		Quiz quiz4 = new Quiz("La déclaration d'une méthode suivante :public void traitement() throws IOExceptionprécise que la méthode propage une exception contrôlée", "vrai", "vrai", "faux");
		Quiz quiz5 = new Quiz("class Test{public static void main (String[] args) {try {int a =10;System.out.println (\"a = \" + a );int b = 0 / a;System.out.println (\"b = \" + b);}catch(ArithmeticException e){System.out.println (\"diviser par 0!\"); }finally{System.out.println(\"je suis à l’intérieur de finally\");}}}", "a=10 b=0 Je suis à l’intérieur de finally", "aucun des choix", "a=10 b=0 Je suis à l’intérieur de finally", "a=10 b=0 diviser par 0! je suis à l’intérieur de finally");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(3);
		

		btn_valider = new Button("valider");
		btn_valider.relocate(650, 500);
		panel.getChildren().add(btn_valider);
		btn_valider.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(checkReponseAllQuestion(1)) {
					Tentative(1);
				}
				else {
					Dialogue(null, "Merci de répondre à toutes les questions");
				}
			}
		});
	}

	public static String NiveauActuel(ArrayList<Quiz> q)
	{
		String ret ="QUIZ";
		if(q.size()==5)
		{
			ret= "Niveau 1";
		}
		else if (q.size()==10)
		{
			ret= "Niveau 2";
		}
		else if(q.size()==15)
		{
			ret= "Niveau 3";
		}
		return ret;		
	}
	
	

	public static void remplirePanelNiveau(int niveau) {
		int start , end;
		if(niveau == 1)
		{
			start=0;
			end  =5;
 
		}
		else if(niveau == 2)
		{
			start=5;
			end  =10;
		}
		else
		{
			start=10;
			end  =15;
		}
		panel.getChildren().clear();
		lapel_score =new Label();
		lapel_score.relocate(700,30);
		panel.getChildren().add(lapel_score);
		lapelTime.relocate(700,10);
		panel.getChildren().add(lapelTime);
		int y=40;
		for(int i = start;i<end;i++) {
			int x=30;
			Label lapel_question = new Label(listeQuiz.get(i).getQuestion());
			lapel_question.relocate(x, y);
			panel.getChildren().add(lapel_question);
			
			y += 50;
			RadioButton choise1 = new RadioButton(listeQuiz.get(i).getChoice_one());
			choise1.relocate(x, y);
			panel.getChildren().add(choise1);
			
			x += 200;
			RadioButton choise2 = new RadioButton(listeQuiz.get(i).getChoice_two());
			choise2.relocate(x, y);
			panel.getChildren().add(choise2);

			ToggleGroup bg = new ToggleGroup();
			bg.getToggles().add(choise1);
			bg.getToggles().add(choise2);
			
			if(listeQuiz.get(i).getChoice_three() != null) {
				x += 200;
				RadioButton choise3 = new RadioButton(listeQuiz.get(i).getChoice_three());
				choise3.relocate(x, y);
				panel.getChildren().add(choise3);
				bg.getToggles().add(choise3);
			}
			y += 40;
			listeButtonGroup.add(bg);
		}
	}
	
	public static void getreponses(int niveau)
	{
		int start , end;
		if(niveau == 1)
		{
			start=0;
			end  =5;
 
		}
		else if(niveau == 2)
		{
			start=5;
			end  =10;
		}
		else
		{
			start=10;
			end  =15;
		}
		for(int i = start;i<end;i++) {
			boolean choice; 
			RadioButton b1 = (RadioButton) listeButtonGroup.get(i).getSelectedToggle();
			if(listeQuiz.get(i).getReponse() == b1.getText()) {
				choice=true;
			}
			else {
				choice=false;
			}
			Player_QUIZ player_QUIZ = new Player_QUIZ(player1.getId_Player(), listeQuiz.get(i).getId_quiz(), b1.getText(), choice);
			listePlayer_QUIZ.add(player_QUIZ);
		}
	}

	public static int calculeScore(int niveau)
	{
		int start , end;
		if(niveau == 1)
		{
			start=0;
			end  =5;
 
		}
		else if(niveau == 2)
		{
			start=5;
			end  =10;
		}
		else
		{
			start=10;
			end  =15;
		}
		int score = 0;
		for(int i = start;i<end;i++) {
			if(listePlayer_QUIZ.get(i).isGoodchoice()) {
				score += 20;
			}
		}
		return score;
	}
	
	public static boolean checkReponseAllQuestion(int niveau){
		int start , end;
		if(niveau == 1)
		{
			start=0;
			end  =5;
 
		}
		else if(niveau == 2)
		{
			start=5;
			end  =10;
		}
		else
		{
			start=10;
			end  =15;
		}
		boolean ret=true;
		for(int i = start;i<end;i++) {
			if(listeButtonGroup.get(i).getSelectedToggle() == null) {
				ret = false;
			}
		}
		return ret;
	}
	
	
	public static void correction(int niveau){
		int start , end;
		if(niveau == 1)
		{
			start=0;
			end  =5;
 
		}
		else if(niveau == 2)
		{
			start=5;
			end  =10;
		}
		else
		{
			start=10;
			end  =15;
		}
		for(int i = start;i<end;i++) {
			if(listePlayer_QUIZ.get(i).isGoodchoice()) {
				RadioButton b1 = (RadioButton) listeButtonGroup.get(i).getSelectedToggle();
				b1.setStyle("-fx-text-fill : green");
			}
			else{
				ToggleGroup t1 = listeButtonGroup.get(i);
				for (Toggle t : t1.getToggles()) {
					RadioButton b1 = (RadioButton) t;
					if(b1.isSelected()) {
						b1.setStyle("-fx-text-fill : green");
					}
					else if(b1.getText() == listeQuiz.get(i).getReponse()) {
						b1.setStyle("-fx-text-fill : red");
					}
				}
			}
		}
	}
	
	public static void Tentative(int niveau) {
		if (cpt == 0) {
			getreponses(niveau);
			if (tentative == 0 ) {
				if ( (niveau == 1 && calculeScore(1) >= 40) || (niveau == 2 && calculeScore(2) >= 60) || (niveau == 3 && calculeScore(3) >= 80)) {
					afficheCorrection(niveau);
				}
				else {
					tentative = 1;
					for (int i = 0; i < 5; i ++) {
						listePlayer_QUIZ.remove(listePlayer_QUIZ.size()-1);
					}
					Dialogue("Attention", "Votre réponses sont incorrect, vous avez une autre tentative!");
				}
			}
			else {
                tentative = 0; 
                afficheCorrection(niveau);
            }
        }
        else {
            afficheCorrection(niveau);
        }
    }
	
	public static void Dialogue(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Alert");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
	
	public static void getDiagWithImage(String chemin, String Title) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setResizable(true);
        alert.getDialogPane().setPrefSize(400, 320);
        Image image = new Image("file:"+chemin);
        ImageView imageView = new ImageView(image);
        alert.setGraphic(imageView);
        alert.showAndWait();
    }
	
	public static void afficheCorrection(int niveau) {
		if(cpt==0) {
			cpt=1;
			btn_valider.setText("Suivant");
			correction(niveau);
			lapel_score.setText("Score : " + calculeScore(niveau));
		}
		else {
			cpt=0;
			if(niveau==1) {
				if(calculeScore(1) >= 40) {
					
					niveau2();
					
				}
				else {
					getDiagWithImage("lose.gif", "you lost");
                    System.exit(0);
				}
			}
			else if(niveau==2) {
				if(calculeScore(2) >= 60) {
					niveau3();
					
				}
				else {
					getDiagWithImage("lose.gif", "you lost");
                    System.exit(0);
				}
			}
			else {
				if(calculeScore(3) >= 80) {
					getDiagWithImage("win.gif", "you win");
					  System.exit(0);
					
				}
				else {
					getDiagWithImage("lose.gif", "you lost");
                    System.exit(0);
				}
				
			}
	}
}
	
	public static void playerMusic(String chemin) {
        if(music!=null) {
            music.stop();
            music=null;
        }
        music = new MP3Player(new File(chemin));
        music.setRepeat(true);
        music.play();
    }
}
