package br.com.caesarcipher;

import java.util.Scanner;

public class CaesarCipher {
	private String message;
	private int key;
	private static char[] 
		alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	
	public CaesarCipher() {
		super();
	}
	
	public CaesarCipher(String message, int key) {
		super();
		this.message = message;
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public static char[] getAlphabet() {
		return alphabet;
	}

	public static void setAlphabet(char[] alphabet) {
		CaesarCipher.alphabet = alphabet;
	}
	
	
	public void readData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a mensagem");
		setMessage(sc.nextLine().toLowerCase());
		
		System.out.println("Digite a chase Desejada");
		setKey(sc.nextInt());
		
		sc.close();
	}
	
	public char[] encrypt() {
		
		char[] newMessage = new char [getMessage().length()];
		
		for(int i=0; i<getMessage().length(); i++) {
			if(getMessage().charAt(i) == ' ') {
				newMessage[i] = getMessage().charAt(i);
			}else {
				for(int j=0; j<getAlphabet().length; j++) {
					if(getMessage().charAt(i) == getAlphabet()[j]) {
						if(getKey()<0) {
							newMessage[i] = getAlphabet()[(j + getKey() + getAlphabet().length) % getAlphabet().length];
							j = getAlphabet().length;
						}else {
							newMessage[i] = getAlphabet()[(j + getKey()) %getAlphabet().length];
							j = getAlphabet().length;
						}
					}else {
						newMessage[i] = getMessage().charAt(i);
					}
				}
			}
		}
		
		return newMessage;
	}
	
	
}
