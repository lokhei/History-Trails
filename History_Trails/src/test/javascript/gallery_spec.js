describe('Testing API...', function() {

    // let result = [];
    beforeEach(function(done) {
        setTimeout(function() {
            // do some stuff
            done();
        }, 500);
    });

    it('Fetches all the objects', async function(done) {
        const result = await fetchObjects();
        expect(result.length).toBe(115);
        done();
    });

    it('Extracts all relevant information about the objects', async function(done) {
        const result = await fetchObjects();
        let objectsGallery2 = [];
        for (var i = 0; i < 115; i++) {
            if (result[i].fields.gallery == "Gallery 2") {
                objectsGallery2.push(result[i]);
            }
        }
        expect(objectsGallery2[0].recordid).toBe("b2b810de148a48a51ddd54ae124389c6831ec3bc");
        expect(objectsGallery2[0].fields.title_of_object).toBe("Young Italian Girl");
        expect(objectsGallery2[0].fields.artist).toBe("Thomas COUTURE");
        expect(objectsGallery2[0].fields.artist_s_birth_death).toBe("1815 – 1879");
        expect(objectsGallery2[0].fields.year_of_creation).toBe("about 1877");
        expect(objectsGallery2[0].fields.label).toBe("Painted in broad brushstrokes, Couture has captured the head and shoulders of a young, dark haired girl in traditional Italian folk costume. She has turned her face to the right and gazes into the distance. Her long coral bead necklace with its gilt cross pendant stands out from her white shirt. Striving to achieve recognition and success at the Paris Salon, Thomas Couture produced a number of large, complex compositions in the grand tradition. By contrast, this more intimate painting demonstrates the more spontaneous side of his nature. It is one of a number of studies which Couture made of the strolling Italian players who passed by his home at Villiers-le-Bel in 1877. Couture was a popular and influential teacher in Paris and encouraged his pupils to retain the qualities of the sketch, such as pure colour and fresh brushwork, in their finished paintings. Among his pupils were Edouard Manet, Pierre Puvis de Chavannes, and several American artists.");
        done();
    });

    it('Gallery 2', async function (done) {
        const result = await fetchObjects();
        let objectsGallery2 = [];
        for (var i = 0; i < 115; i++) {
            if (result[i].fields.gallery == "Gallery 2") {
                objectsGallery2.push(result[i]);
            }
        }
        expect(objectsGallery2.length).toBe(31);
        done();
    });

    it('Gallery 3 - European Old Masters', async function (done) {
        const result = await fetchObjects();
        let objectsGallery3 = [];
        for (var i = 0; i < 115; i++) {
            if (result[i].fields.gallery == "Gallery 3 - European Old Masters") {
                objectsGallery3.push(result[i]);
            }
        }
        expect(objectsGallery3.length).toBe(44);
        done();
    });

    it('Gallery 4', async function (done) {
        const result = await fetchObjects();
        let objectsGallery4 = [];
        for (var i = 0; i < 115; i++) {
            if (result[i].fields.gallery == "Gallery 4") {
                objectsGallery4.push(result[i]);
            }
        }
        expect(objectsGallery4.length).toBe(22);
        done();
    });

    it('Gallery 5 - Modern Art', async function (done) {
        const result = await fetchObjects();
        let objectsGallery5 = [];
        for (var i = 0; i < 115; i++) {
            if (result[i].fields.gallery == "Gallery 5 - Modern Art") {
                objectsGallery5.push(result[i]);
            }
        }
        expect(objectsGallery5.length).toBe(18);
        done();
    });

    it('Works all links to additional information', async function (done) {
        const result = await fetchObjects();
        let urls = [];
        for (var i = 0; i < 115; i++) {
            var url = result[i].fields.link_to_additional_information;
            if (url) {
                urls.push(url);
            }
        }
        for (var i = 0; i < urls.length; i++) {
            const request = await fetch(urls[i]);
            expect(request.status).toBe(200);
        }
        done();
    })
});
