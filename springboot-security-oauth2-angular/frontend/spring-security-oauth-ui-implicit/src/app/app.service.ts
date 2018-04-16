import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RequestOptions } from '@angular/http';
import { Router } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { Cookie } from 'ng2-cookies';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

export class Foo {
  constructor(
    public id: number,
    public name: string) { }
}

@Injectable()
export class AppService {

  constructor(
    private _router: Router, private _http: HttpClient, private oauthService: OAuthService) {
    this.oauthService.loginUrl = 'http://localhost:7081/spring-security-oauth-server/oauth/authorize';
    this.oauthService.redirectUri = 'http://localhost:4201/';
    this.oauthService.clientId = 'sampleClientId';
    this.oauthService.scope = 'read write foo bar';
    this.oauthService.setStorage(sessionStorage);
    this.oauthService.oidc = false;
    this.oauthService.tryLogin({});
  }

  obtainAccessToken() {
    this.oauthService.initImplicitFlow();
  }

  getResource(resourceUrl): Observable<Foo> {
    const headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + this.oauthService.getAccessToken()
    });
    return this._http.get(resourceUrl, { headers: headers })
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  isLoggedIn() {
    console.log(this.oauthService.getAccessToken());
    if (this.oauthService.getAccessToken() === null) {
      return false;
    }
    return true;
  }

  logout() {
    this.oauthService.logOut();
    location.reload();
  }

}
