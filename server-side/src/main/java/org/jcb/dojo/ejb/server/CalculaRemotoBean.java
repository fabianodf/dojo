package org.jcb.dojo.ejb.server;

import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jcb.framework.Divisao;
import org.jcb.framework.Multiplicacao;
import org.jcb.framework.Nodo;
import org.jcb.framework.Soma;
import org.jcb.framework.Subtracao;
import org.jcb.framework.Valor;

@Stateless
@Remote(CalculaRemoto.class)
public class CalculaRemotoBean implements CalculaRemoto{

	@PostConstruct
	private void incia(){
		System.out.println("Inicia com @PostConstruct CalculaRemotoBean");
	}
	
	//Assume que o primeiro item da Lista recebida é o operando nº1, o segundo item é o operador e o terceiro item é o segundo operando. Ex: (2) (+) (2)
	@Override
	public String calcula(List<String> expressao) {
		
		
		try{
			
			String num1 = expressao.get(0);
			Nodo esquerda = new Valor(Integer.parseInt(num1));
			
			int operacao = Integer.parseInt(expressao.get(1));
			
			String num2 = expressao.get(2);
			Nodo direita = new Valor(Integer.parseInt(num2));
			
			
			Nodo resultado = new Valor(0);
			String resposta = "";
		
			if (operacao == 1) {
				resultado = new Soma(esquerda, direita);
				//System.out.print("\nO resultado da soma é: ");
				resposta = "O resultado da soma é: ";
			} else if (operacao == 2) {
				resultado = new Subtracao(esquerda, direita);
				//System.out.print("\nO resultado da subtração é: ");
				resposta = "O resultado da subtração é: ";
			} else if (operacao == 3) {
				resultado = new Multiplicacao(esquerda, direita);
				//System.out.print("\nO resultado da multiplicação é:" );
				resposta = "O resultado da multiplicação é: ";
			} else if (operacao == 4) {
				resultado = new Divisao(esquerda, direita);
				//System.out.printf("\nO resultado da divisão é:");
				resposta = "O resultado da divisão é: ";
			} else {
				//System.out.println("????");
				resposta = "????";
			}

			//System.out.println( resultado.calcula());
			return (resposta + " " + resultado.calcula());

		}catch(Exception e){
			return "Erro, reveja os parâmetros passados: "+expressao; 
		}
		
	}
		
	
}
