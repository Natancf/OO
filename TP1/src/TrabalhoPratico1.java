import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TrabalhoPratico1 {
	public static final int TEMAS = 51;
	public static final int PALAVRAS = 51;
	public static void main(String[] args) {
		int menu=0;
		String jogo[][] = new String[TEMAS][PALAVRAS];
		int quant = 0;
		int quant_palavras=10;
		int valida = 0;
		int opcao_temas = 0;
		int opcao_palavras = 0;
		int opcao_jogar = 0;
		String carrega_temas[][] = {{"animais", "rato", "cachorro", "cavalo", "barata","vaca","gato","coelho","formiga","papagaio","baleia"}, 
									{"paises", "brasil", "argentina", "paraguai", "alemanha","inglaterra","canada","suiça","chile","peru","bolivia"}, 
									{"cores", "branco", "preto", "amarelo", "azul","vermelho","verde","roza","laranja","marrom","cinza"}, 
									{"estados", "parana", "roraima", "rondonia", "amapa","amazona","tocantins","para","pernambuco","alagoas","bahia"}, 
									{"comidas", "pizza", "arroz", "hamburgue", "batata","frango","amendoim","chocolate","bolo","sanduiche","pastel"}};
		String palavra_sorteada="";
		int erros = 0;
        int acertos = 0;
        
		for (int j = 0; j < 5; j++) { //carregando o programa com temas
			if(jogo[j][0] == null) {
				jogo[j][0] = carrega_temas[j][0];
			}
		}
		for (int c = 0; c < 5; c++) { //carregando o programa com palavras
			for (int k = 1; k < 11; k++) {
				if (jogo[c][k] == null) {
					jogo[c][k] = carrega_temas[c][k];
				}
			}
		}
		
		do {
			System.out.println("+------------------------------------------+");
			System.out.println("|                  Menu:                   |");
			System.out.println("+------------------------------------------+");
			System.out.println("| 01 - Gerenciar Temas                     |");
			System.out.println("| 02 - Gerenciar Palavras                  |");
			System.out.println("| 03 - Jogar                               |");
			System.out.println("| 04 - Sair                                |");
			System.out.println("+------------------------------------------+");
			Scanner ler = new Scanner(System.in);
			menu = ler.nextInt();
			switch (menu) {
	        	case 1:
	        		do {
	        			System.out.println("+------------------------------------------+");
	        			System.out.println("|             Gerenciar Temas              |");
	        			System.out.println("+------------------------------------------+");
	        			System.out.println("| 01 - Cadastro                            |");
	        			System.out.println("| 02 - Exclusão                            |");
	        			System.out.println("| 03 - Buscar	                           |");
	        			System.out.println("| 04 - Sair                                |");
	        			System.out.println("+------------------------------------------+");
	        			opcao_temas = ler.nextInt();
	        			switch (opcao_temas) {
	        				case 1:
	        		    		principal: for (int i = 0; i < 51; i++) { //cadastra temas
	        		    			for (int j = quant; j < 51; j++) {
	        		    				System.out.println("| Digite o tema");
	        		    		        System.out.println("| Digite \"p\" para voltar ao menu ");
	        		    		        String temas = ler.next();
	        		    		        
	        		    		        if("p".equals(temas)) {
	        		    	        		break principal;
	        		    	        	}
	        		    		        if(temas.equals(jogo[i][0])) {
	        		    		        	System.out.println("| Este tema ja existe, tente outro ");
	        		    		        }else {
		        		    				jogo[j][0] = temas;
		        		    		        quant ++;
	        		    		        }
	        		    			}
	        		    		}
	        					
	        					break;
	        				case 2:
	        					TrabalhoPratico1.excluir_tema(jogo,quant); //exclui tema
	        					break;
	        				case 3:
	        					TrabalhoPratico1.pesquisar_tema(jogo); //pesquisa tema
	        					break;
	        			}
	        		}while(opcao_temas != 4);
	        		break;	
	        	case 2:
	        		do {
		        		System.out.println("+------------------------------------------+");
	        			System.out.println("|            Gerenciar Palavra             |");
	        			System.out.println("+------------------------------------------+");
	        			System.out.println("| 01 - Cadastro                            |");
	        			System.out.println("| 02 - Exclusão                            |");
	        			System.out.println("| 03 - Buscar	                           |");
	        			System.out.println("| 04 - Listagem	                           |");
	        			System.out.println("| 05 - Sair                                |");
	        			System.out.println("+------------------------------------------+");
		        		opcao_palavras = ler.nextInt();
	        		
	        			switch(opcao_palavras) {
		        			case 1:
		        				System.out.println("| Gerenciar Palavras"); //cadastra palavras
		            	    	System.out.println("| Escolha um tema");
		        				for (int c = 0; c < 51; c++) {
		            				if(jogo[c][0] != null) {
		            					System.out.println("| " + jogo[c][0]);
			        				}
		        				}
		            			String escolher_tema = ler.next();
		            			
		            			for (int j = 0; j < 51; j++) {
		            				
		            				if (escolher_tema.equals(jogo[j][0])) {
		            					for (int z = quant; z < jogo.length; z++) {
		    		        				System.out.println("| Digite a palavra ");
		    		        		        System.out.println("| Digite \"p\" para voltar ao menu ");
		    		        		        String palavras = ler.next();
		    		        		        if ("p".equals(palavras)) {
		    		        		            break;
		    		        		        }
		    		        		        if(palavras.equals(jogo[j][z])) {
		    			    		        	System.out.println("| Este palavra ja existe, tente outra ");
		    			    		        	quant --;
		    			    		        }else {
		    			    		        	jogo[j][z] = palavras;
		    	    		    		        quant ++;
		    	    		    		        quant_palavras++;
		    			    		        }
		    		        			}
		    		        			valida = 1;
		            					
		            				}else if(valida == 0){
		            					System.out.println("| Tema não encontrado!");
		            				}
		    	        	    }
		    	        		break;
		        			case 2:
		        				TrabalhoPratico1.excluir_palavras(jogo,quant,valida); // exclui palavras
		        				break;
		        			case 3:
		        				pesquisar_palavra(jogo); // pesquisa por uma palavra
		        				break;
		        			case 4:
		        				listar_palavras(jogo); // lista todas as palavras cadastradas
		        				break;
	        			}
	        		} while(opcao_palavras != 5);
	        		break;
	        	case 3:
	        		do {
	        			System.out.println("+------------------------------------------+");
	        			System.out.println("|            Gerenciar Palavra             |");
	        			System.out.println("+------------------------------------------+");
	        			System.out.println("| 01 - Seleção de tema                     |");
	        			System.out.println("| 02 - Jogo                                |");
	        			System.out.println("| 03 - Jogar Novamente                     |");
	        			System.out.println("| 04 - Sair                                |");
	        			System.out.println("+------------------------------------------+");
	        			int tamanho = palavra_sorteada.length();
		        		opcao_jogar = ler.nextInt();
        				ThreadLocalRandom palavra_sortear = ThreadLocalRandom.current();
        		        int pl_sr = palavra_sortear.nextInt(1, quant_palavras); //sorteia um número dentro do numero de palavras existentes
		        		switch(opcao_jogar) {
		        			case 1: // escolhe um tema
		        				System.out.println("| Escolha um tema");
		        				for (int c = 0; c < 51; c++) {
		        					if(jogo[c][0] != null) {
		        						System.out.println("| " + jogo[c][0]);
		        					}
		        				}
		        				String escolher_tema_jogar = ler.next();
		        				for (int j = 0; j < 51; j++) {
		        					if (escolher_tema_jogar.equals(jogo[j][0])) {
		        						if (jogo[j][pl_sr] != null ) {
		        							palavra_sorteada = jogo[j][pl_sr];
		        							
		        							break;
		        						}
		        					}
		        				}
		        				break;
		        			case 2: // executa o jogo da forca
		        				char tamanho_palavra[] = new char[tamanho];
		        				for (int i = 0; i < tamanho; i++) {
		        		            tamanho_palavra[i] = '_';
		        		            System.out.print(tamanho_palavra[i]);
		        		        }
        			        	
        			            
        			        	boolean achou = false;
        			            while (erros < 6 && acertos < tamanho) {
        			            	System.out.print("\n");
        			                String forca =
        			                          " |----------------------|  \n" //
        			                        + " |                      A  \n" //
        			                        + " |                     DBC \n" //
        			                        + " |                     F E \n";//

        			                switch (erros) {
        			                    case 0:
        			                        forca = forca.replace('A', ' ').replace('B', ' ').replace('C', ' ').replace('D', ' ').replace('E', ' ').replace('F', ' ');
        			                        break;
        			                    case 1:
        			                        forca = forca.replace('A', 'O').replace('B', ' ').replace('C', ' ').replace('D', ' ').replace('E', ' ').replace('F', ' ');
        			                        break;
        			                    case 2:
        			                        forca = forca.replace('A', 'O').replace('B', '|').replace('C', ' ').replace('D', ' ').replace('E', ' ').replace('F', ' ');
        			                        break;
        			                    case 3:
        			                        forca = forca.replace('A', 'O').replace('B', '|').replace('C', '\\').replace('D', ' ').replace('E', ' ').replace('F', ' ');
        			                        break;
        			                    case 4:
        			                        forca = forca.replace('A', 'O').replace('B', '|').replace('C', '\\').replace('D', '/').replace('E', ' ').replace('F', ' ');
        			                        break;
        			                    case 5:
        			                        forca = forca.replace('A', 'O').replace('B', '|').replace('C', '\\').replace('D', '/').replace('E', '\\').replace('F', ' ');
        			                        break;
        			                    case 6:
        			                        forca = forca.replace('A', 'O').replace('B', '|').replace('C', '\\').replace('D', '/').replace('E', '\\').replace('F', '/');
        			                        break;
        			                }
        			                System.out.println(forca);
    			                System.out.print("Digite uma letra: ");
    			                char letra = ler.next().charAt(0);

    			                
			                    for (int i = 0; i < tamanho; i++) {
			                        if (palavra_sorteada.charAt(i) == letra) {
			                        	tamanho_palavra[i] = letra;
			                            achou = true;
			                            acertos++;
			                        }
			                    }
			                    if (!achou) {
			                        erros++;
			                    }
    			                
    			                System.out.println("Erros: " + erros);

    			                for (int i = 0; i < tamanho; i++) {
    			                    System.out.print(tamanho_palavra[i] + " ");
    			                }
    			                System.out.println();
    			                achou = false;
    			            }
    			            if (erros == 6) {
    			                System.out.println("Você foi enforcado!");
    			                System.out.println("A palavra era: " + palavra_sorteada);
    			                erros = 0;
    			                acertos = 0;
    			                achou = false;
    			            } else {
    			                System.out.println("PARABÉNS, você acertou a palavra!");
    			                erros = 0;
    			                acertos = 0;
    			                achou = false;
    			            }
	        			        break;
		        			case 3: //joga novamente
		        				System.out.println("| Escolha um tema");
		        				for (int c = 0; c < 51; c++) {
		        					if(jogo[c][0] != null) {
		        						System.out.println("| " + jogo[c][0]);
		        					}
		        				}
		        				escolher_tema_jogar = ler.next();
		        				for (int j = 0; j < 51; j++) {
		        					if (escolher_tema_jogar.equals(jogo[j][0])) {
		        						if (jogo[j][pl_sr] != null ) {
		        							palavra_sorteada = jogo[j][pl_sr];
		        							
		        							break;
		        						}
		        					}
		        				}
		        				break;
		        		}
	        			
	        		}while(opcao_jogar != 4);
	        		
	        		break;	
	        	case 4:
	        		break;
	        	default:
	        		System.out.println("| Digite um valor valido");
			}
		}while(menu != 4);
	}
	
	public static String[][] excluir_tema(String jogo[][], int quant) { //metodo para excluir temas
		Scanner ler = new Scanner(System.in);
		System.out.println("| Qual tema deseja excluir?");
		for (int j = 0; j < jogo.length; j++) {
			if(jogo[j][0] != null) {
				System.out.println("| " + jogo[j][0]);
			}
		}
        String excluir = ler.next();
        for (int j = 0; j < jogo.length; j++) {
	        if (excluir.equals(jogo[j][0])) {
	        	if(jogo[j][1] == null) {
	        		jogo[j][0] = null;
	        		break;
	        	}else {
	        		System.out.println("| Não foi possivel excluir o tema");
	        	}
	        }
        }
    	return jogo;
	}

	public static void pesquisar_tema(String jogo[][]){ //metodo para pesquisar por temas
		Scanner ler = new Scanner(System.in);
		System.out.println("| Pesquisar tema:");
		String pesquisar = ler.next();
		for (int j = 0; j < jogo.length; j++) {
	        if (pesquisar.equals(jogo[j][0])) {
	        	int cont = 1;
	        if (cont == 1) {
	        	System.out.println("| Este tema está cadastrado");
		        break;
	        }else {
		       	System.out.println("| Tema não encontrado");
		     	}
	        }
	    }
	}
	
	public static String[][] excluir_palavras(String jogo[][], int quant,int teste) { //metodo para excluir palavras
		Scanner ler = new Scanner(System.in);
		int validar = 0;
		int valida = 0;
		
    	System.out.println("| Escolha um tema");
		for (int c = 0; c < 51; c++) {
			if(jogo[c][0] != null) {
				System.out.println("| " + jogo[c][0]);
			}
		}
		String escolher_tema_excluir = ler.next();
		
		for (int j = 0; j < 51; j++) {
			if (escolher_tema_excluir.equals(jogo[j][0])) {
				for (int z = 0; z < jogo.length; z++) {
					for (int p = 1;p < jogo.length; p++) {
	    		        if(jogo[z][p] != null) {
	    					System.out.println("| " + jogo[z][p]);
	    				}
					}
    				
					System.out.println("| Digite a palavra a ser excluida");
    		        System.out.println("| Digite \"p\" para voltar");
    		        String excluir = ler.next();
    		        if ("p".equals(excluir))
    		        {
    		        	break;
    		        }
    		        for (int c = 0; c < 51; c++) {
    					for (int k = 1; k < jogo.length; k++) {
    						if (excluir.equals(jogo[c][k])) {
				        		validar = 1;
				        		if (validar != 0) {
				        			jogo[c][k] = null;
    				        		break;
				        		}else {
				        			System.out.println("| Não foi possivel excluir o tema");
				        		}
    				        }
    					}
    		        }
    			}
    			teste = 1;
				
			}else if(teste == 0){
				System.out.println("| Tema não encontrado!");
			}
	    }
    	return jogo;
	}
	
	public static void pesquisar_palavra(String jogo[][]){ // metodo para pesquisar palavras
		Scanner ler = new Scanner(System.in);
		
		System.out.println("| Pesquisar tema:");
		String pesquisar = ler.next();
		for (int j = 0; j < jogo.length; j++) {
	        for(int i = 0; i < jogo.length; i++) {
	        	if (pesquisar.equals(jogo[j][i])) {
		        	int cont = 1;
		        if (cont == 1) {
		        	System.out.println("| Esta palavra está cadastrada");
			        break;
		        }else {
			       	System.out.println("| palavra não encontrada");
			     	}
		        }
	        }
	    }
	}
	
	public static void listar_palavras(String jogo[][]){ // metodo para listar todas as palavras
		Scanner ler = new Scanner(System.in);
		
		System.out.println("| Escolha um tema");
		for (int c = 0; c < jogo.length; c++) {
			if(jogo[c][0] != null) {
				System.out.println("| " + jogo[c][0]);
			}
		}
		String escolher_tema_listar = ler.next();
		
		for (int j = 0; j < 51; j++) {
			if (escolher_tema_listar.equals(jogo[j][0])) {
				for (int z = 0; z < jogo.length; z++) {
					for (int p = 1;p < jogo.length; p++) {
	    		        if(jogo[z][p] != null) {
	    					System.out.println("| " + jogo[z][p]);
	    				}
					}
				}
			}
		}
	}
	
}
