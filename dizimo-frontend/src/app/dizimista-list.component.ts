import { Component, OnInit } from '@angular/core';
import { Dizimista } from './dizimista';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'dizimista-list',
  templateUrl: './dizimista-list.component.html'
})

export class DizimistaListComponent implements OnInit {
  dizimistas: Dizimista[];
  newDizimista: Dizimista = new Dizimista();
  editing: false;
  editingDizimista: Dizimista = new Dizimista();

  ngOnInit(): void {
    this.getDizimistas();
  }

  getDizimistas(): void {

  }

  createDizimista(dizimistaForm: NgForm): void {

  }

  deleteDizimista(id: number): void {

  }

  updateDizimista(dizimistaData: Dizimista): void {

  }

  toggleCompleted(dizimistaData: Dizimista): void {

  }

  editDizimista(dizimistaData: Dizimista): void {

  }

  clearEditing(): void {

  }  
}
