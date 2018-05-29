import {DizimistaService} from '../../services/dizimista/dizimista.service';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-dizimista',
  templateUrl: './dizimista.component.html',
  styleUrls: ['./dizimista.component.css']
})
export class DizimistaComponent implements OnInit {

  dizimistas: Array<any> = [];
  errorMessage: any;

  constructor(private _dizimistaService: DizimistaService, private _router: Router,
    private _activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.getDizimistas();
  }

  getDizimistas() {
    this._dizimistaService.getDizimistas().subscribe(
      data => this.dizimistas = data,
      error => this.errorMessage = error
    );
  }

  add() {
    this._router.navigate(['dizimista/add']);
  }

  edit(id) {
    this._router.navigate(['dizimista/edit/' + id])
  }

  delete(id) {
    var ans = confirm("Realmente quer deletar este produto: " + id);
    if (ans) {
//      this._dizimistaService.deleteProduto(id)
//        .subscribe(data => {
//          var index = this.produtos.findIndex(x => x.id == id);
//          this.produtos.splice(index, 1);
//        }, error => this.errorMessage = error)
    }
  }


}
