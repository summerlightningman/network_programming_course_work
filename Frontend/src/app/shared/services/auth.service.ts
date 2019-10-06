export class AuthService {
  isLoggedIn: boolean;

  logIn() {
    this.isLoggedIn = true;
  }

  logOut() {
    window.localStorage.removeItem('id');
    this.isLoggedIn = false;
  }

  isAuth() {
    return new Promise((resolve, reject) => {
      resolve(this.isLoggedIn);
    });
  }

}
