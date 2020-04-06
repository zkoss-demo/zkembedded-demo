import { Selector } from 'testcafe'; // first import testcafe selectors

fixture('Minimal').page('http://localhost:9000/minimal.html');

test('Minimal', async t => {
    const h1Title = Selector('h1');
    const zkWindow = Selector('.z-window');
    const zkLabel = Selector('.z-label');
    const zkButton = Selector('.z-button');
    const clientInput = Selector('#clientInput');

    await t
        .expect(h1Title.textContent).eql('ZK Embedded Minimal')
        .expect(zkWindow.exists).ok()
        .expect(zkLabel.exists).ok()
        .expect(zkLabel.textContent).eql('init-from-client-side')
        .expect(clientInput.value).eql('initial')

        .click('#clientSideButton')
        .expect(zkLabel.textContent).contains('update-from-client-side')

        .click(zkButton)
        .expect(clientInput.value).eql('updated-from-server');
});
