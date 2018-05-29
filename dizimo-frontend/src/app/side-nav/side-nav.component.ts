import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit() {
  }

  openNav() {
    document.getElementById("mySidenav").style.width = "25%";
  }

  closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }

  abrirPagina(menu) {
    this._router.navigate([menu]);
    this.closeNav();
  }
}
