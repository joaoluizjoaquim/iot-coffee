import { CoffeeFrontPage } from './app.po';

describe('coffee-front App', () => {
  let page: CoffeeFrontPage;

  beforeEach(() => {
    page = new CoffeeFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
