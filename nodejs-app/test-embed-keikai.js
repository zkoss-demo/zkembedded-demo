import { Selector } from 'testcafe'; // first import testcafe selectors

fixture('Embedded Keikai').page('http://localhost:9000/demo-bootstrap.html');

test('Embedded Keikai', async t => {
    const navbarBrand = Selector('.navbar-brand');
    const embeddedZK = Selector('#embeddedZK');
    const loadDemoLink = Selector('#a_load');
    const zkPage = Selector('.z-page');
    const zsSheet = Selector('.zssheet');
    const zssCellContent = Selector('.zsblock');

    await t
        .expect(navbarBrand.textContent).eql('Embedded Keikai Spreadsheet')
        .expect(embeddedZK.exists).ok()
        .expect(zkPage.exists).ok()
        .expect(zsSheet.exists).ok()
        .expect(zssCellContent.exists).ok()
        .expect(zssCellContent.textContent).eql('', 'expect initially empty sheet')
        .click(loadDemoLink)
        .expect(zssCellContent.textContent).contains('Ratio Analysis', 'expect demo sheet cell content')
});
