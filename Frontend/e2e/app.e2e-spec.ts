import { SocialdimaPage } from './app.po';

describe('socialdima App', () => {
  let page: SocialdimaPage;

  beforeEach(() => {
    page = new SocialdimaPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
