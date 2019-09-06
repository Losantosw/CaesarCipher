package br.com.caesarcipher;

public class Main {
	public static void main(String[] args) {
		
		CaesarCipher cc = new CaesarCipher();
		
		cc.readData();
		System.out.println(cc.encrypt());
	}
}
