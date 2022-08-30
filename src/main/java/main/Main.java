package main;

import java.util.List;

import business.LivroBusiness;
import entity.Livro;
import exceptions.NotFoundException;

public class Main {

	public static void main(String[] args) {
		LivroBusiness livroBusiness = new LivroBusiness();
		livroBusiness.save( "Os contos de Gabriel", "Gabriel's Tales", "Julian", "Veja", 200, 1 );
		livroBusiness.save("Os contos de Julian", "Julian's Tales", "Julian", "Veja", 250, 1);
		livroBusiness.save("Batata", "Potato", "Julian", "NaoVeja", 88, 2);

		try {
			System.out.println(livroBusiness.findById(2));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();
		try {
			System.out.println(livroBusiness.findByAuthor("Julian"));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		livroBusiness.remove(2);
		try {
			livroBusiness.update(1, "Gabriel e os seus contos", "Gabriel's Tales", "Julian", "GJScan", 180, 2);
		} catch (NotFoundException e1) {
			e1.printStackTrace();
		}
		
		System.out.println();
		try {
			System.out.println(livroBusiness.findByAuthor("Julian"));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
