/**
 * 
 */
package net.vompi.eclipse;

import java.util.Arrays;

/**
 * @author dani
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args == null || args.length == 0){
			System.out.println("No arguments passed!");
		} else {
			System.out.println(args);
			System.out.println(Arrays.toString(args));
		}
	}

}
