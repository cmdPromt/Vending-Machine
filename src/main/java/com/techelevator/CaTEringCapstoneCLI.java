package com.techelevator;

import com.techelevator.view.Accounting;
import com.techelevator.view.Menu;


import java.util.Scanner;


public class CaTEringCapstoneCLI {
	boolean keepRunning = true;

	private final Menu menu;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public static void printHomeMenu() {


		System.out.println(" *********************************************");
		System.out.println("                DMITRII'S DELI                  ");
		System.out.println(" *********************************************");
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		System.out.printf("*%11s%1s%10s","","(D)Display Catering Items","*\n");
		System.out.println("**********************************************");
		System.out.printf("*%17s%1s%18s","","(P)Purchase","*\n");
		System.out.println("**********************************************");
		System.out.printf("*%19s%1s%20s"," ","(E)Exit", "*\n");
		System.out.println("**********************************************");


	}


	public void run() {

		try {

			do {

				printHomeMenu();
				Scanner menuScan = new Scanner(System.in);
				String menuChoose = menuScan.nextLine();
				if (menuChoose.equalsIgnoreCase("D")) {
					System.out.println(Menu.displayProducts());
				} else if (menuChoose.equalsIgnoreCase("P")) {
					Accounting.purchaseMenu();
				} else if (menuChoose.equalsIgnoreCase("E")) {
					keepRunning = false;
				} else if (menuChoose.equalsIgnoreCase("S")) {
//					salesReport();
				} else {
					System.out.println("Please enter valid choice");
				}

			} while (keepRunning);



		} catch (Exception e) {
			System.out.println("Message ");
		}

	}
}
