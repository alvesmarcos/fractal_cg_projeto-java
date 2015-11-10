package br.com.mhas.engine;

import br.com.mhas.model.Card;


public interface ICardType {
	
	//atributtes
	
	public static final int SIZE_CARD = 36;
	
	
	public static final Card [] CARD_ARRAY = {	new Card(1,"Whale", 85, 95, "water", "/card-whale.png"),
	
												new Card(2, "Bear", 80, 70, "earth", "/card-bear.png"),
	
												new Card(3, "Bird", 60, 65, "air", "/card-bird.png"),
	
												new Card(4, "Butterfly", 55, 65, "air", "/card-butterfly.png"),
	
												new Card(5, "Cat-1", 55, 50, "earth", "/card-cat1.png"),
	
												new Card(6, "Cat-2", 65, 60, "earth", "/card-cat2.png"),
	
												new Card(7, "Cat-3", 70, 65, "earth", "/card-cat3.png"),
	
												new Card(8, "Snake", 85, 65, "earth", "/card-snake.png"),
	
												new Card(9, "Rabbit", 50, 50, "earth", "/card-rabbit.png"),
												
												new Card(10, "Falcon", 95, 80, "air", "/card-falcon.png"),
												
												new Card(11, "Owl-1", 50, 50, "air", "/card-owl1.png"),
												
												new Card(12, "Owl-2", 60, 60, "air", "/card-owl2.png"),
												
												new Card(13, "Squirrel", 60, 55, "earth", "/card-squirrel.png"), 
												
												new Card(14, "Fenix", 100, 100, "air", "/card-fenix.png"),
												
												new Card(15, "Fish", 55,55, "water", "/card-fish.png"),
												
												new Card(16, "Sea Lion", 60, 80, "water", "/card-sea-lion.png"),
												
												new Card(17, "Hawk-1", 80, 75, "air", "/card-hawk1.png"),
												
												new Card(18, "Hawk-2", 90, 85, "air", "/card-hawk2.png"),
												
												new Card(19, "Horse", 70, 70, "earth", "/card-horse.png"),
												
												new Card(20, "Ounce", 85, 80, "earth", "/card-ounce.png"),
												
												new Card(21, "Leopard-1", 80, 80, "earth", "/card-leopard1.png"),
												
												new Card(22, "Lion", 100, 100, "earth", "/card-lion.png"),
												
												new Card(23, "Wolf", 80, 70, "earth", "/card-wolf.png"),
												
												new Card(24, "Tiger-2", 95, 90, "earth", "/card-tiger2.png"),
												
												new Card(25, "Pand", 60, 55, "earth", "/card-pand.png"),
												
												new Card(26, "Leopard-2", 85, 85, "earth", "/card-leopard2.png"),
												
												new Card(27, "Panther", 75, 65, "earth", "/card-panther.png"),
												
												new Card(28, "Macaw", 60, 55, "air", "/card-macaw.png"),
												
												new Card(29, "Owl-3", 70, 65, "air", "/card-owl3.png"),
												
												new Card(30, "Tiger", 90, 85, "earth", "/card-tiger.png"),
												
												new Card(31, "White-Tiger-1", 95, 90, "earth", "/card-white-tiger1.png"),
												
												new Card(32, "White-Tiger-2", 110, 100, "earth", "/card-white-tiger2.png"),
												
												new Card(33, "Shark", 90, 85, "water", "/card-shark.png"),
												
												new Card(34, "White-Shark", 100, 95, "water", "/card-white-shark.png"),
												
												new Card(35, "Hammerhead-Shark", 75, 85, "water", "/card-hammerheard-shark.png"),
												
												new Card(36, "Vulture", 70, 80, "air", "/card-vulture.png") };
	
}
