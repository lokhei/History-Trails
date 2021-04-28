describe('Testing API...', function() {

    // let result = [];
    beforeEach(function(done) {
        setTimeout(function() {
            // do some stuff
            done();
        }, 500);
    });

    it('fetches all the objects', async function(done) {
        const result = await fetchObjects();
        expect(result.length).toBe(115);
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
            const request = await fetch(urls[0]);
            expect(request.status).toBe(200);

        }
        
        done();

    })

});
