package Formes;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
	
	// Initialise les variables utilisées dans les méthodes
	
	
	public static ArrayList<Pokemon> list = new ArrayList<>();
	public static Pokemon pokemonJoueur = new Pokemon("a", "a", new String[][] {{"a"}, {"x"}, {"a"}, {"x"}}, 1 ,1, 1, 1 ,1 ,1); 
	public static Pokemon pokemonAdverse = new Pokemon("a", "a", new String[][] {{"a"}, {"x"}, {"a"}, {"x"}}, 1,1, 1, 1 ,1 ,1); 
	public static double coeffElement = 1;
	public static boolean turn = true;
	public static boolean stopBattle = false;
	
	public static ArrayList<String> experienceGaps = new ArrayList<>();
	
	public static int attackNumber = 0;
	public static String moveAttack = "";
	public static double moveAttackNb = 0;
	
	public static int randomAttack = 0;
	public static double computerMoveAttackNb = 0;
	public static String computerMoveAttack = "";
	
	String pokemonName, pokemonType;
	String[][] pokemonAttacks;
	int pokemonHp, pokemonAttackPower, pokemonDefensePower, pokemonSpeed, pokemonLevel, pokemonExperience;

	public Pokemon(String name, String type, String[][] attacks, int hp, int attackPower, int defensePower, int speed,
			int level, int experience) {
		pokemonName = name;
		pokemonType = type;
		pokemonAttacks = attacks;
		pokemonHp = hp;
		pokemonAttackPower = attackPower;
		pokemonDefensePower = defensePower;
		pokemonSpeed = speed;
		pokemonLevel = level;
		pokemonExperience = experience;
	}

	public static void initialPowerUp() {
		pokemonJoueur.pokemonHp += 3;
		pokemonJoueur.pokemonAttackPower += 3;
		pokemonJoueur.pokemonDefensePower += 3;
		pokemonJoueur.pokemonSpeed += 3;
	}
	
	public static void xpGain(Pokemon pokemonJoueur) {
	/*	if(pokemonJoueur.pokemonHp > 0) {
			pokemonJoueur.pokemonExperience += 100;
		}*/
		for (int i =0; i < experienceGaps.size(); i++) {
			System.out.println(experienceGaps.get(i));
			System.out.println("azfa");
		/*	if(pokemonJoueur.pokemonExperience >= Double.parseDouble(experienceGaps.get(i))) {
				levelUp(pokemonJoueur);
				experienceGaps.remove(i);
				
			}*/
		}
	}
	
	public static void levelUp(Pokemon pokemonJoueur) {
		pokemonJoueur.pokemonHp += 3;
		pokemonJoueur.pokemonAttackPower += 3;
		pokemonJoueur.pokemonDefensePower += 3;
		pokemonJoueur.pokemonSpeed += 3;
		pokemonJoueur.pokemonLevel += 1;
		System.out.println("Niveau augmenté ! " + pokemonJoueur.pokemonAttackPower);
	}
	
	public static void pokemonListCreation() { // !!! Il fallait simplement définir list en public static hors de la fonction pour que la méthode puisse l'utiliser !
		// Liste des pokemons à choisir
		// new String[] important pour mettre un tableau dans un objet !!!!!
		list.add(new Pokemon("Bulbizarre", "plante",
				new String[][] { {"charge", "10", "degat", "normal", "Charge sur l'ennemi"},
								 {"rugissement", "0.7", "debuff pokemonAttackPower", "normal", "baisse la pokemonAttackPower de l'ennemi"},
								 {"liane", "20", "degat", "plante", "fouette l'ennemi avec une liane" },
								 {"-", "-", "-", "-", "-"}}, 200, 5, 5, 5, 1, 0));
		list.add(new Pokemon("Carapuce", "eau",
				new String[][] { {"charge", "10", "degat", "normal", "Charge sur l'ennemi"},
								 {"carapace",  "1.6", "buff defense", "normal", "augmente la pokemonDefensePower"},
								 {"jet d'eau", "20", "degat", "eau", "Asperge l'ennemi"},
								 {"-", "-", "-", "-", "-"}}, 200, 5, 5,
				5, 1, 0));
		list.add(new Pokemon("Salameche", "feu",
				new String[][] {{"charge", "10", "degat", "normal", "Charge sur l'ennemi"},
			 				    {"rugissement", "0.7", "debuff attaque", "normal", "baisse la pokemonAttackPower de l'ennemi"},
			 				    {"Flammeche", "20", "degat", "feu", "Envoie une flamme sur l'ennemi"},
			 				   {"-", "-", "-", "-", "-"}}, 200, 5,
				5, 5, 1, 0));
	}

	public static void pokemonChoice(ArrayList<Pokemon> list) {
		Scanner console = new Scanner(System.in);
		System.out.println("Quel pokemon choisissez-vous ? :");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("- " + (i + 1) + " " + list.get(i).pokemonName);
		}
		int pokemonChoisi = console.nextInt() - 1;
		pokemonJoueur = list.get(pokemonChoisi);
		System.out.println("Votre pokemon est " + pokemonJoueur.pokemonName);
		
		// Récupère l'objet que l'on va supprimer pour l'aléatoire du pokemon ordi
		
		Pokemon X = new Pokemon(pokemonJoueur.pokemonName, pokemonJoueur.pokemonType,
				new String[][] { {pokemonJoueur.pokemonAttacks[0][0], pokemonJoueur.pokemonAttacks[0][1],
			pokemonJoueur.pokemonAttacks[0][2], pokemonJoueur.pokemonAttacks[0][3], pokemonJoueur.pokemonAttacks[0][4]},
			{pokemonJoueur.pokemonAttacks[1][0], pokemonJoueur.pokemonAttacks[1][1],
				pokemonJoueur.pokemonAttacks[1][2], pokemonJoueur.pokemonAttacks[1][3], pokemonJoueur.pokemonAttacks[1][4]},
			{pokemonJoueur.pokemonAttacks[2][0], pokemonJoueur.pokemonAttacks[2][1],
					pokemonJoueur.pokemonAttacks[2][2], pokemonJoueur.pokemonAttacks[2][3], pokemonJoueur.pokemonAttacks[2][4]},
			{pokemonJoueur.pokemonAttacks[3][0], pokemonJoueur.pokemonAttacks[3][1],
						pokemonJoueur.pokemonAttacks[3][2], pokemonJoueur.pokemonAttacks[3][3], pokemonJoueur.pokemonAttacks[3][4]}
		},
				pokemonJoueur.pokemonHp, pokemonJoueur.pokemonAttackPower, pokemonJoueur.pokemonDefensePower,
				pokemonJoueur.pokemonSpeed, pokemonJoueur.pokemonLevel, pokemonJoueur.pokemonExperience);
		// Retire le pokemon choisi de l'ArrayList le temps que l'ordi fasse son tirage aléatoire
		list.remove(pokemonChoisi);
	}
	
	public static void computerChoice(ArrayList<Pokemon> list) {
		int max = list.size() - 1; 
		int min = 0; // Minimal index of list
		int range = max - min + 1;
		int random = (int) (Math.round(range) * Math.random());
		pokemonAdverse = list.get(random);
		System.out.println("Votre adversaire sera " + list.get(random).pokemonName);
	}
	
	public static void displayAttacks(Pokemon pokemonJoueur) {
		for (int i = 0; i < pokemonJoueur.pokemonAttacks.length; i++) {
			System.out.println("- " + (i + 1) + " " + pokemonJoueur.pokemonAttacks[i][0]);
		}
	}
	
	  public static boolean checkWin(Pokemon pokemonJoueur, Pokemon pokemonAdverse) {
		  if (pokemonJoueur.pokemonHp < 1 || pokemonAdverse.pokemonHp < 1) {
			  return true;
		  }
	  else {
		  return false;}
	  }
	  
	  public static String playerMoveAttack() {
		  Scanner console = new Scanner(System.in);
		  System.out.println("Quel coup voulez-vous utiliser ?");
			attackNumber = console.nextInt();
			moveAttack = pokemonJoueur.pokemonAttacks[attackNumber - 1][1]; 
			double moveAttackNb = Double.parseDouble(moveAttack);
			System.out.print(moveAttackNb); // 0.7
			return moveAttack;
	  }
	  
	  public static String computerMoveAttack() {
		  	int maxAttack = 2;
			int minAttack = 0;
			int rangeAttack = maxAttack - minAttack;
			randomAttack = (int) Math.round(Math.random() * rangeAttack);
			computerMoveAttack = pokemonAdverse.pokemonAttacks[randomAttack][1];
			System.out.println(pokemonAdverse.pokemonName + " utilise " + pokemonAdverse.pokemonAttacks[randomAttack][0]);
			return moveAttack;
	  }
	  
	  public static void playerDebuff() {
		  String arr[] = pokemonJoueur.pokemonAttacks[attackNumber - 1][2].split(" ");
		   String stat = arr[1]; 
		   
		   double moveAttackNb = Double.parseDouble(moveAttack);
			System.out.println(stat); // 0.7
			System.out.println(stat);
			System.out.println(stat);
			
		 switch (stat) {
			   case "attaque": 
				   if(pokemonAdverse.pokemonAttackPower <= 2) {
						 System.out.println("L'attaque du pokemon adverse n'ira pas plus bas !");
						 break;
					 } else {
						 pokemonAdverse.pokemonAttackPower = (int) (pokemonAdverse.pokemonAttackPower * moveAttackNb);
						   System.out.println("L'attaque de " + pokemonAdverse.pokemonName +" est passée à " + pokemonAdverse.pokemonAttackPower);
						   System.out.println(moveAttackNb);
						   break;
					 }
				  
			   case "defense":
				   if(pokemonAdverse.pokemonDefensePower <= 2) {
						 System.out.println("La défense du pokemon adverse n'ira pas plus bas !");
						 break;
					 } else {
						 pokemonAdverse.pokemonDefensePower = (int) (pokemonAdverse.pokemonDefensePower * moveAttackNb);
						   System.out.println("La défense de " + pokemonAdverse.pokemonName +" est passée à " + pokemonAdverse.pokemonDefensePower);
						   break;
					 }
			   }  
	  }
	  
	  public static void ComputerDebuff() {
		  
		  computerMoveAttackNb = Double.parseDouble(computerMoveAttack);
		  String arr[] = pokemonAdverse.pokemonAttacks[randomAttack][2].split(" ");
		   String stat = arr[1];
		   switch (stat) {
		   case "attaque": 
			   if(pokemonJoueur.pokemonAttackPower <= 2) {
					 System.out.println("L'attaque de ton pokemon n'ira pas plus bas !");
					 break;
				 } else {
					 pokemonJoueur.pokemonAttackPower = (int) (pokemonJoueur.pokemonAttackPower * computerMoveAttackNb);
					   System.out.println(
								pokemonAdverse.pokemonName + " utilise " + pokemonAdverse.pokemonAttacks[randomAttack][0]);
					 
					   System.out.println("L'attaque de " + pokemonJoueur.pokemonName +" est passée à " + pokemonJoueur.pokemonAttackPower);
					   break;
				 }
		   case "defense":
			   if(pokemonJoueur.pokemonDefensePower <= 2) {
					 System.out.println("La défense de ton pokemon n'ira pas plus bas !");
					 break;
				 } else {
					 pokemonJoueur.pokemonDefensePower = (int) (pokemonJoueur.pokemonDefensePower * computerMoveAttackNb);
					   System.out.println(
								pokemonAdverse.pokemonName + " utilise " + pokemonAdverse.pokemonAttacks[randomAttack][0]);
					   System.out.println("La défense de " + pokemonJoueur.pokemonName +" est passée à " + pokemonJoueur.pokemonDefensePower);
					   break;
				 }
		   }
	  }
	  
	  public static void playerBuff(double moveAttackNb) { 
			   String arr[] = pokemonJoueur.pokemonAttacks[attackNumber - 1][2].split(" ");
			   String stat = arr[1];
	
			   moveAttackNb = Double.parseDouble(moveAttack);
			   
			   switch (stat) {
			   case "attaque": 
				   pokemonJoueur.pokemonAttackPower = (int) (pokemonJoueur.pokemonAttackPower * moveAttackNb);
				   System.out.println("L'attaque de " + pokemonJoueur.pokemonName +" est passée à " + pokemonJoueur.pokemonAttackPower);
				   break;
			   case "defense":
				   pokemonJoueur.pokemonDefensePower = (int) (pokemonJoueur.pokemonDefensePower * moveAttackNb);
				   System.out.println("La défense de " + pokemonJoueur.pokemonName +" est passée à " + pokemonJoueur.pokemonDefensePower);
				   break;
			   }
		} 
	  
	  public static void ComputerBuff(double moveAttackNb) { 
		  String arr[] = pokemonAdverse.pokemonAttacks[randomAttack][2].split(" ");
		   String stat = arr[1];
		   
		   computerMoveAttackNb = Double.parseDouble(computerMoveAttack);
		   
		   switch (stat) {
		   case "attaque": 
			   pokemonAdverse.pokemonAttackPower = (int) (pokemonAdverse.pokemonAttackPower * computerMoveAttackNb);
			   System.out.println("L'attaque de " + pokemonAdverse.pokemonName +" est passée à " + pokemonAdverse.pokemonAttackPower);
			   break;
		   case "defense":
			   //System.out.println("computerMoveAttackNb = " +computerMoveAttackNb);
			   //System.out.println("defensePokemonAdv = " + pokemonAdverse.pokemonDefensePower);
			   pokemonAdverse.pokemonDefensePower = (int) (pokemonAdverse.pokemonDefensePower * computerMoveAttackNb);
			   System.out.println("La défense de " + pokemonAdverse.pokemonName +" est passée à " + pokemonAdverse.pokemonDefensePower);
			   break;
		   }
		} 
	  
	  public static void playerDamage() {
		  moveAttackNb = Double.parseDouble(moveAttack);
		  pokemonAdverse.pokemonHp -= moveAttackNb * pokemonJoueur.pokemonAttackPower * coeffElement;
			System.out.println("Il reste " + pokemonAdverse.pokemonHp + " hp à l'ennemi !");
			checkWin(pokemonJoueur, pokemonAdverse);
			if(checkWin(pokemonJoueur, pokemonAdverse)) {
				xpGain(pokemonJoueur);
				System.out.printf(pokemonAdverse.pokemonName +" est KO !%nVous avez gagné");
				
				stopBattle = true;
			}
	  }
	  
	  public static void ComputerDamage() {
		  computerMoveAttackNb = Double.parseDouble(computerMoveAttack);
		  
		  pokemonJoueur.pokemonHp -= computerMoveAttackNb * pokemonAdverse.pokemonAttackPower;
			
			System.out.println("Il reste " + pokemonJoueur.pokemonHp + "hp à votre pokemon !");
			if(checkWin(pokemonJoueur, pokemonAdverse)) {
				System.out.printf(pokemonJoueur.pokemonName +" est KO !%nVous avez perdu");
				stopBattle = true;}		
	  }
	   
	  public static void combat() {
		  do {
			  if (turn == true) {
				    playerMoveAttack();
				    System.out.println(moveAttackNb);
					System.out.println(pokemonJoueur.pokemonName + " utilise " + pokemonJoueur.pokemonAttacks[attackNumber - 1][0]);
					//coeffValue(pokemonJoueur,pokemonAdverse);
					if(pokemonJoueur.pokemonAttacks[attackNumber - 1][2].indexOf("debuff") >= 0) {
						System.out.print(moveAttackNb);
						playerDebuff();
						System.out.print(moveAttackNb);
						} else if(pokemonJoueur.pokemonAttacks[attackNumber - 1][2].indexOf("buff") >= 0) {
						playerBuff(moveAttackNb);
						}
							else {
								coeffJoueurValue(pokemonJoueur, pokemonAdverse);
								playerDamage();
								coeffElement = 1;
							}
						turn = !turn;
					}
					
			 else { computerMoveAttack();
					//coeffValue(pokemonJoueur,pokemonAdverse);
					if(pokemonAdverse.pokemonAttacks[randomAttack][2].indexOf("debuff") >= 0) {
						ComputerDebuff();
						} else if(pokemonAdverse.pokemonAttacks[randomAttack][2].indexOf("buff") >= 0) {
							ComputerBuff(computerMoveAttackNb);
						} else {
							coeffComputerValue(pokemonJoueur, pokemonAdverse);
							ComputerDamage();
							coeffElement = 1;
						}
					turn = !turn;
			  }
		  }while(stopBattle == false);
	  }
	  public static void main(String[] args) {
		  
			pokemonListCreation();
			pokemonChoice(list);
			xpGain(pokemonJoueur);
			initialPowerUp();
			computerChoice(list);
			System.out.printf("%nLe combat commence !%nQuelle attaque allez-vous utiliser ? %n %n");
			displayAttacks(pokemonJoueur);
			combat();
			
			stopBattle = false;
			
			list.remove(pokemonAdverse);
			computerChoice(list);
			combat();
		}
	  public static void coeffJoueurValue(Pokemon pokemonJoueur, Pokemon pokemonAdverse) { 
			if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("plante") == true
					&& pokemonAdverse.pokemonType == "eau")) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			} else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("plante") == true
					&& pokemonAdverse.pokemonType == "feu")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			}  else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("feu") == true
					&& pokemonAdverse.pokemonType == "plante") 
					) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			} else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("feu") == true
					&& pokemonAdverse.pokemonType == "eau")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("eau") == true
					&& pokemonAdverse.pokemonType == "feu")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			}else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("eau") == true
					&& pokemonAdverse.pokemonType == "plante")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("eau") == true
					&& pokemonAdverse.pokemonType == "electrique")) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonJoueur.pokemonAttacks[attackNumber - 1][3].contains("electrique") == true
					&& pokemonAdverse.pokemonType == "eau")
					) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			}
		}
		  
		public static void coeffComputerValue(Pokemon pokemonJoueur, Pokemon pokemonAdverse) { 
			if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("plante") == true
					&& pokemonJoueur.pokemonType == "eau")) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			} else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("plante") == true
					&& pokemonJoueur.pokemonType == "feu")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			}  else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("feu") == true
					&& pokemonJoueur.pokemonType == "plante") 
					) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			} else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("feu") == true
					&& pokemonJoueur.pokemonType == "eau")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("eau") == true
					&& pokemonJoueur.pokemonType == "feu")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			}else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("eau") == true
					&& pokemonJoueur.pokemonType == "plante")
					) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("eau") == true
					&& pokemonJoueur.pokemonType == "electrique")) {
				coeffElement = 0.5;
				System.out.println("Ce n'est pas très efficace ...");
			} else if ((pokemonAdverse.pokemonAttacks[randomAttack][3].contains("electrique") == true
					&& pokemonJoueur.pokemonType == "eau")
					) {
				coeffElement = 1.6;
				System.out.println("C'est super efficace !");
			}
		}

}