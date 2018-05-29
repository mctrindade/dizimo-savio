import {DizimistaService} from '../../../services/dizimista/dizimista.service';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-dizimista-edit',
  templateUrl: './dizimista-edit.component.html',
  styleUrls: ['./dizimista-edit.component.css']
})
export class DizimistaEditComponent implements OnInit {

  errorMessage: any;
  id = '0';
  dizimistaForm: FormGroup;
  igrejas: Array<any> = [];
  submitted = false;

  constructor(private _avRoute: ActivatedRoute,
    private _fb: FormBuilder,
    private _router: Router,
    private _dizimistaService: DizimistaService
  ) {
    this.dizimistaForm = this._fb.group({
      id: '0',
      nome: ['', [Validators.required,
                  Validators.minLength(3),
                  Validators.maxLength(30)]],
      telefoneFixo: ['', [Validators.required]],
      endereco: ['', [Validators.required]],
      telefoneCelular: ['', [Validators.required]],
      igreja: ['', [Validators.required]],
      dataNascimento: ['', [Validators.required]],
    });

    //Toda vez que entrar com um id na url, atribui seu valor a variavel id 
    if (this._avRoute.snapshot.params['id']) {
      this.id = this._avRoute.snapshot.params['id'];
    }


  }

  ngOnInit() {
    //Recupera lista de igrejas
    this.getIgrejas();

    //Verifica se o id foi setado para recuperar o dizimista a ser editado
    if (this.id !== '0') {
      this._dizimistaService.getDizimistaById(this.id)
        .subscribe(resp => this.dizimistaForm.setValue(resp)
        , error => this.errorMessage = error);
    }
  }

  getIgrejas() {
    this._dizimistaService.getIgrejas().subscribe(resp => this.igrejas = resp,
      error => this.errorMessage = error);
  }
  
  save(){
    this.submitted = true;
    if (!this.dizimistaForm.valid) {
      return;
    }
    this._dizimistaService.saveDizimista(this.dizimistaForm.value)
      .subscribe(dizimista => {
        this._router.navigate(['dizimista']);
      }, error => this.errorMessage = error);
  }
  
  cancel(id) {
    this._router.navigate(['dizimista'])
  }
  
  get nome() {return this.dizimistaForm.get('nome');}
  get endereco() {return this.dizimistaForm.get('endereco');}
  get telefoneFixo() {return this.dizimistaForm.get('telefoneFixo');}
  get telefoneCelular() {return this.dizimistaForm.get('telefoneCelular');}
  get igreja() {return this.dizimistaForm.get('igreja');}
  get dataNascimento() {return this.dizimistaForm.get('dataNascimento');}
  

}
