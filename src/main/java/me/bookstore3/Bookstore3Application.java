package me.bookstore3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.bookstore3.entities.Book;
import me.bookstore3.repositories.BookRepository;

@SpringBootApplication
public class Bookstore3Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore3Application.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
        	repository.save(new Book("Before We Were Yours: A Novel", "Lisa Wingate", 340.00, "no"));
        	repository.save(new Book("When Never Comes", "Barbara Davis", 179.00, "no"));
        	repository.save(new Book("Giraffes Can't Dance", "Giles Andreae, Guy Parker-Rees", 200.50, "no"));
        	repository.save(new Book("The Great Alone: A Novel Kristin Hannah", "Kristin Hannah", 495.00, "yes"));
        	repository.save(new Book("An American Princess: The Many Lives of Allene Tew", "Annejet van der Zijl, Michele Hutchison", 149.00, "yes"));
        	repository.save(new Book("Medical Medium Life-Changing Foods", "Anthony William", 929.70, "no"));
        	repository.save(new Book("Vegan 100", "Gaz Oakley", 897.96, "no"));
        	repository.save(new Book("Have You Filled A Bucket Today?", "Carol McCloud", 290.06, "no"));
        	repository.save(new Book("The Very Hungry Caterpillar", "Eric Carle", 208.51, "no"));
        	repository.save(new Book("The Hate U Give", "Angie Thomas", 319.16, "no"));
        	repository.save(new Book("The Alice Network", "Kate Quinn", 393.22, "no"));
        	repository.save(new Book("Harry Potter - A History of Magic", "British Library", 1379.78, "no"));
        };
    }
}
