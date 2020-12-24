/*import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;*/

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Timer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Execution implements Application {
	
	static Stage frame;
	static Scene panel;
	static ArrayList<ToggleGroup> listeButtonGroup;
	static Players player1;
	static Timer t; 
	static Label lapelTime;
	static String chemin;
	static int cpt=0;
	static Button btn_valider;
	static Label lapel_score;
	static int tentative;

	public static void main(String[] args) {
	 
 
		listeButtonGroup = new ArrayList<ToggleGroup>();
		ArrayList<Quiz> listeQuiz = new ArrayList<Quiz>();
		ArrayList<Player_QUIZ> listePlayer_QUIZ = new ArrayList<Player_QUIZ>();
	 
		
		frame = new Stage("Quiz");
		frame.setBounds(100, 100, 800, 600);
		panel = new LayeredPane();
		frame.getContentPane().add(panel);
		login();
	 
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		lapelTime= new Label();
		
		playerMusic("quiz-show.mp3",30000);
		
		
	}
	public static void StopMusic()  throws JavaLayerException
	{
		if (player!=null)
		  {
		    player.close();
		    player = null;
		    
		  }
	}
	
	public static void playerMusic(String chemin,int frames)
	{
		
		try 
		{
			FileInputStream fileInputStrem = new FileInputStream(chemin);
			player = new Player(fileInputStrem);
			player.play(frames);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(JavaLayerException e)
		{
			e.printStackTrace();
		}
		 
	}
	
	
	
	public static void login() {
		
		
		Label label_nom = new Label("nom");
		label_nom.setBounds(30, 30, 60, 20);
		panel.add(label_nom);
		
		Label label_prenom = new Label("prenom");
		label_prenom.setBounds(30, 70, 60, 20);
		panel.add(label_prenom);
		
		Label label_age = new Label("age");
		label_age.setBounds(30, 110, 60, 20);
		panel.add(label_age);
		
		TextField txt_nom = new TextField();
		txt_nom.setBounds(90, 30, 140, 20);
		panel.add(txt_nom);
		
		TextField txt_prenom = new TextField();
		txt_prenom.setBounds(90, 70, 140, 20);
		panel.add(txt_prenom);
		
		TextField txt_age = new TextField();
		txt_age.setBounds(90, 110, 140, 20);
		panel.add(txt_age);
		
		Button btn_debut = new Button("d�marrer le quiz");
		btn_debut.setBounds(80, 150, 140, 25);
		panel.add(btn_debut);
		btn_debut.addEventHandler(new EventHandler() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				player1 = new Players(txt_nom.getText(), txt_prenom.getText(), Integer.parseInt(txt_age.getText()));
				//viderPanelNiveau();
				t = new Timer(1000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(player1.getDuration() > 0) {
							player1.setDuration(player1.getDuration()-1);
							lapelTime.setText(LocalTime.MIN.plusSeconds(player1.getDuration()).toString());
							frame.setTitle(NiveauActuel(listeQuiz));
						}
						else {
							t.stop();
							Dialogue(null, "GAME OVER");
		                    System.exit(0);
						}
					}
				});
				java.util.Timer tt = new java.util.Timer(false);
		        tt.schedule(new TimerTask() {
		            @Override
		            public void run() {
		                t.start();
		            }
		        }, 0);
				niveau1();
				
				
			}
		});
	}
	
	public static void niveau1() {
		Quiz quiz1 = new Quiz("JAVA est  un langage", "Compil� et interpret�", "Compil�", "Interpr�t�", "Compil� et interpret�");
		Quiz quiz2 = new Quiz("Toutes les classes h�ritent de la classe", "Object", "Main", "Object", "AWT");
		Quiz quiz3 = new Quiz("Par convention une classe", "commence par une majuscule", "est en minuscule", "commence par une majuscule", "est en majuscules");
		Quiz quiz4 = new Quiz("Est-ce que on peut avoir plusieurs constructeurs pour la m�me classe", "oui", "oui", "non");
		Quiz quiz5 = new Quiz("Dans la ligne \"public class A implements B\", B est:", "Interfacce", "Interfacce", "Classe parent", "Package");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(1);
		

		btn_valider = new Button("valider");
		btn_valider.setBounds(650, 500, 100, 30);
		panel.add(btn_valider);
		btn_valider.addEventHandler(new EventHandler() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkReponseAllQuestion(1)) {
					Tentative(1);
				}
				else {
					Dialogue(null, "Merci de r�pondre � toutes les questions");
				}
			}
		});
	}
	
	public static void niveau2() {
		
		Quiz quiz1 = new Quiz("Apr�s la compilation, un programme �crit en JAVA, il se transforme en programme en bytecode. Quelle est l�extension du programme en bytecode ?", ".Class", "aucun des choix", ".JAVA", ".Class");
		Quiz quiz2 = new Quiz("Class Test{Public Test () {System.out.println(�Bonjour�);}public Test (int i) {this(); System.out.println(�Nous sommes en �+i+�!�);}; }qu�affichera l�instruction suivante? Test t1=new Test (2020);", "Bonjour Nous sommes en 2020 !", "aucun des choix", "Bonjour Nous sommes en 2020 !", "Nous sommes en 2020 !");
		Quiz quiz3 = new Quiz("Voici un constructeur de la classe Employee, y-a-t'il un probl�me Public void Employe(String n){Nom=n;}", "vrai", "vrai", "faux");
		Quiz quiz4 = new Quiz("Pour sp�cifier que la variable ne pourra plus �tre modifi�e et doit �tre initialis�e d�s sa d�claration, on la d�clare comme une constante avec le mot r�serv�", "final", "aucun des choix", "final","const");
		Quiz quiz5 = new Quiz("Dans une classe, on acc�de � ses variables gr�ce au mot cl�", "this", "aucun des choix", "this", "super");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(2);
		
		Button btn_valider = new Button("valider");
		btn_valider.setBounds(650, 500, 100, 30);
		panel.add(btn_valider);
		btn_valider.addEventHandler(new EventHandler() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkReponseAllQuestion(2)) {
					Tentative(2);
				}
				else {
					Dialogue(null, "Merci de r�pondre � toutes les questions");
				}
			}
		});
	}
	
	public static void niveau3() {
		Quiz quiz1 = new Quiz("calculerSalaire(int) calculerSalaire(int, double)La m�thode calculerSalaire est:", "surcharg�e", "aucun des choix", "surcharg�e", "red�finie");
		Quiz quiz2 = new Quiz("Une classe qui contient au moins une m�thode abstraite doit �tre d�clar�e abstraite.", "vrai", "vrai", "faux");
		Quiz quiz3 = new Quiz("Est-ce qu�une classe peut impl�menter plusieurs interfaces?", "vrai", "vrai", "faux");
		Quiz quiz4 = new Quiz("La d�claration d'une m�thode suivante :public void traitement() throws IOExceptionpr�cise que la m�thode propage une exception contr�l�e", "vrai", "vrai", "faux");
		Quiz quiz5 = new Quiz("class Test{public static void main (String[] args) {try {int a =10;System.out.println (\"a = \" + a );int b = 0 / a;System.out.println (\"b = \" + b);}catch(ArithmeticException e){System.out.println (\"diviser par 0!\"); }finally{System.out.println(\"je suis � l�int�rieur de finally\");}}}", "a=10 b=0 Je suis � l�int�rieur de finally", "aucun des choix", "a=10 b=0 Je suis � l�int�rieur de finally", "a=10 b=0 diviser par 0! je suis � l�int�rieur de finally");
		
		listeQuiz.add(quiz1);
		listeQuiz.add(quiz2);
		listeQuiz.add(quiz3);
		listeQuiz.add(quiz4);
		listeQuiz.add(quiz5);
		
		remplirePanelNiveau(3);
		
		Button btn_valider = new Button("valider");
		btn_valider.setBounds(650, 500, 100, 30);
		panel.add(btn_valider);
		btn_valider.addEventHandler(new EventHandler() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkReponseAllQuestion(3)) {
					Tentative(3);
				}
				else {
					Dialogue(null, "Merci de r�pondre � toutes les questions");
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
	
	
	
	public static int nbrReponseCorrect(int niveau ,ArrayList<Quiz> q1,ArrayList<Player_QUIZ> pq)
	{
		int start , end;
		if(niveau == 1)
		{
			start = 0;
			end   = 5;
 
		}
		else if(niveau == 2)
		{
			start = 5;
			end   = 10;
		}
		else
		{
			start = 10;
			end   = 15;
		}
		
		
		 int totalReponseCorrectParNiveau =0;
		  
		 for(int i = start; i<end; i++) {
 			 
			 if(q1.get(i).getId_quiz() == pq.get(i).getId_quiz())
			 {
				 if(q1.get(i).getReponse().equals(pq.get(i).getReponseChosen()))
				 {
					 totalReponseCorrectParNiveau++;
				 
					 
				 }
				  
			 }
			 
			}
		 
		 return totalReponseCorrectParNiveau;
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
		panel.removeAll();
		panel.repaint();
		lapel_score =new Label();
		lapel_score.setBounds(700,30,70,20);
		panel.add(lapel_score);
		lapelTime.setBounds(700,10,70,20);
		panel.add(lapelTime);
		int y=40;
		for(int i = start;i<end;i++) {
			int x=30;
			Label lapel_question = new Label("<html><p>"+listeQuiz.get(i).getQuestion()+"</p></html>");
			lapel_question.setBounds(x, y, 700, 60);
			panel.add(lapel_question);
			
			y += 50;
			RadioButton choise1 = new RadioButton("<html><p>"+listeQuiz.get(i).getChoice_one()+"</p></html>");
			choise1.setActionCommand(listeQuiz.get(i).getChoice_one());
			choise1.setBounds(x, y, 200, 30);
			panel.add(choise1);
			
			x += 200;
			RadioButton choise2 = new RadioButton("<html><p>"+listeQuiz.get(i).getChoice_two()+"</p></html>");
			choise2.setActionCommand(listeQuiz.get(i).getChoice_two());
			choise2.setBounds(x, y, 200, 30);
			panel.add(choise2);

			ButtonGroup bg = new ButtonGroup();
			bg.add(choise1);
			bg.add(choise2);
			
			if(listeQuiz.get(i).getChoice_three() != null) {
				x += 200;
				RadioButton choise3 = new RadioButton("<html><p>"+listeQuiz.get(i).getChoice_three()+"</p></html>");
				choise3.setActionCommand(listeQuiz.get(i).getChoice_three());
				choise3.setBounds(x, y, 200, 30);
				panel.add(choise3);
				bg.add(choise3);
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
			if(listeQuiz.get(i).getReponse() == listeButtonGroup.get(i).getSelection().getActionCommand()) {
				choice=true;
			}
			else {
				choice=false;
			}
			Player_QUIZ player_QUIZ = new Player_QUIZ(player1.getId_Player(), listeQuiz.get(i).getId_quiz(), listeButtonGroup.get(i).getSelection().getActionCommand(), choice);
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
			if(listeButtonGroup.get(i).getSelection() == null) {
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
				Enumeration<AbstractButton> radsV = listeButtonGroup.get(i).getElements();
		        while (radsV.hasMoreElements()) {
		            RadioButton temp = (RadioButton) radsV.nextElement();
		            if (temp.isSelected()) {
		                temp.setForeground(Color.green);
		                break;
		            }
		        }
			}
			else{
				Enumeration<AbstractButton> radsV = listeButtonGroup.get(i).getElements();
		        while (radsV.hasMoreElements()) {
		            RadioButton temp = (RadioButton) radsV.nextElement();
		            if (temp.isSelected()) {
		                temp.setForeground(Color.red);
		            }
		            else if(temp.getActionCommand() == listeQuiz.get(i).getReponse()) {
		            	temp.setForeground(Color.green);
		            }
		        }
			}
		}
	}
	
	public static void Tentative(int niveau) {
		if (cpt == 0) {
			getreponses(niveau);
			if (tentative == 0 ) {
				if ( niveau == 1 && calculeScore(1) >= 40 || niveau == 2 && calculeScore(2) >= 60 || niveau == 3 && calculeScore(3) >= 80) {
					afficheCorrection(niveau);
				}
				else {
					tentative = 1;
					for (int i = 0; i < 5; i ++) {
						listePlayer_QUIZ.remove(listePlayer_QUIZ.size()-1);
					}
					Dialogue("Attention", "Votre r�ponses sont incorrect, vous avez une autre tentative!");
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
	
	
	
	public static void afficheCorrection(int niveau) {
			if(cpt==0) {
				getreponses(niveau);
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
						 try {
								StopMusic();
							} catch (JavaLayerException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						playerMusic("lose.mp3",100);
						 String invisibleChar= "\u200e";
							final ImageIcon icon = new ImageIcon("lose.gif");
	                        JOptionPane.showMessageDialog(null,invisibleChar, "YOU LOST HAHAHAH", JOptionPane.INFORMATION_MESSAGE, icon);
						
	                    System.exit(0);
					}
				}
				else if(niveau==2) {
					if(calculeScore(2) >= 60) {
						niveau3();
						
					}
					else {
						 try {
								StopMusic();
							} catch (JavaLayerException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						playerMusic("lose.mp3",100);
						 String invisibleChar= "\u200e";
							final ImageIcon icon = new ImageIcon("lose.gif");
	                        JOptionPane.showMessageDialog(null,invisibleChar, "YOU LOST HAHAHAH ", JOptionPane.INFORMATION_MESSAGE, icon);
						
	                    System.exit(0);
					}
				}
				else {
					if(calculeScore(3) >= 80) {

						//affichage du resultat
						t.stop();
						try {
							StopMusic();
						} catch (JavaLayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						playerMusic("win.mp3",100);
	                  
	                   String invisibleChar= "\u200e";
						final ImageIcon icon = new ImageIcon("source.gif");
                        JOptionPane.showMessageDialog(null,invisibleChar, "YOU WON ! ", JOptionPane.INFORMATION_MESSAGE, icon);
						 try {
								StopMusic();
							} catch (JavaLayerException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  System.exit(0);
						
					}
					else {
						 try {
								StopMusic();
							} catch (JavaLayerException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						playerMusic("lose.mp3",100);
						 String invisibleChar= "\u200e";
							final ImageIcon icon = new ImageIcon("lose.gif");
	                        JOptionPane.showMessageDialog(null,invisibleChar, "YOU LOST HAHAHAH ", JOptionPane.INFORMATION_MESSAGE, icon);
						
	                    System.exit(0);
					}
					
				}
		}
	}
}
