package com.SPE.historytrails.History_Trails;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class HistoryTrailsApplicationTests {

	@Autowired
	WebController webcontroller;

	@Test
	void contextLoads() {
	}

	@Test
	void htmlRendering(){
		assert(webcontroller.index().equals("index"));
		assert(webcontroller.MShed().equals("MShed"));
		assert(webcontroller.BristolArtGallery().equals("BristolArtGallery"));
		assert(webcontroller.popular().equals("popular"));
		assert(webcontroller.favourites().equals("favourites"));
		assert(webcontroller.gallery2().equals("Gallery2"));
		assert(webcontroller.gallery3().equals("Gallery3"));
		assert(webcontroller.gallery4().equals("Gallery4"));
		assert(webcontroller.gallery5().equals("Gallery5"));
		assert(webcontroller.more().equals("more"));

	}

}
