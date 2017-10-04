package com.lukasz.plawny.supermarket.cli;

import java.util.Arrays;
import com.lukasz.plawny.supermarket.service.SupermarketCheckoutService;
import com.lukasz.plawny.supermarket.service.SupermarketCheckoutServiceImpl;

/**
 * This class implements command line interface of supermarket checkout
 * application
 * 
 * @author Lukasz Plawny
 *
 */

public class CheckoutCli {

	private final SupermarketCheckoutService supermarketCheckoutService = new SupermarketCheckoutServiceImpl();

	/**
	 * This method starts interactive command line interface of supermarket
	 * checkout application
	 */
	public void runCliCheckout(String[] args) {

		if (args != null) {
			try {
			supermarketCheckoutService.checkout(Arrays.asList(args));
			printActualTotalPrice();
			} catch (IllegalArgumentException e) {
				printIllegalInputInfo();
			}
		}
		askForItems();
		String actualInput = readLine();
		while (!isQuitRequest(actualInput)) {
			try {
				supermarketCheckoutService.checkout(Arrays.asList(actualInput.split(" ")));
				printActualTotalPrice();
				askForItems();
			} catch (IllegalArgumentException e) {
				printIllegalInputInfo();
			}

			actualInput = readLine();
		}
		printActualTotalPrice();
	}

	private void askForItems() {
		System.out.println(CliOutput.ASK_FOR_ITEM_TEXT);
	}

	private String readLine() {
		return System.console().readLine();// TODO this won't work from IDE
	}

	private boolean isQuitRequest(String actualInput) {
		return actualInput.equals(CliOutput.QUIT_INDICATOR);
	}

	private void printIllegalInputInfo() {
		System.out.println(CliOutput.ILLEGAL_INPUT_INFO);

	}

	private void printActualTotalPrice() {
		System.out.println(CliOutput.TOTAL_PRICE_TEXT + supermarketCheckoutService.getActualTotalPrice());

	}

	private static class CliOutput {

		private static final String QUIT_INDICATOR = "q";
		private static final String AVAILABLE_PRODUCTS = "A B C D";
		private static final String AVAILABLE_USER_INPUT = "Input product ids separated by spaces or single product id or "
				+ QUIT_INDICATOR + " for quit. Available products: " + AVAILABLE_PRODUCTS;
		private static final String ASK_FOR_ITEM_TEXT = "Please scan your items. " + AVAILABLE_USER_INPUT;
		private static final String TOTAL_PRICE_TEXT = "Total price: ";
		private static final String ILLEGAL_INPUT_INFO = "Incorrect product id, try again. " + AVAILABLE_USER_INPUT;
	}

}