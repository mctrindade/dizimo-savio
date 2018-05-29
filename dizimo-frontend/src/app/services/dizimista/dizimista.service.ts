import {HttpClientModule} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Http, Response, HttpModule} from '@angular/http';
import { environment } from '../../../environments/environment';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class DizimistaService {

  constructor(private _http: Http) {}

  baseUrl: string = environment.baseUrlRest + 'dizimo'

  getDizimistas() {
    return this._http.get(this.baseUrl +'/dizimista')
      .map((response: Response) => response.json())
      .catch(this._errorHandler);
  }

  getIgrejas() {
    return this._http.get(this.baseUrl + '/igrejas')
      .map((response: Response) => response.json())
      .catch(this._errorHandler);
  }
  
  getDizimistaById(id) {
    return this._http.get(this.baseUrl +'/dizimista/' + id)
      .map((response: Response) => response.json())
      .catch(this._errorHandler)
  }
  
  saveDizimista(dizimista){
    return this._http.post(this.baseUrl+ '/dizimista', dizimista)
      .map((response: Response) => response.json())
      .catch(this._errorHandler)
  }
  
  _errorHandler(error: Response) {
    console.log(error);
    return Observable.throw(error || "Internal server error");
  }
}
