describe('Testing API...', function() {

    // let result = [];
    beforeEach(function(done) {
        setTimeout(function() {
            // do some stuff
            done();
        }, 100);
    });


    it('fetches all the objects', async function(done) {
        const result = await fetchObjects();
        expect(result.length).toBe(115);
        done();

    });

});