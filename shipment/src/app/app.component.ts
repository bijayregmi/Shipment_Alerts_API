import { Component } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'

@Component({
  selector: 'app-root',
  template: `
  <div class ="container">
  <div *ngFor = "let shipments of data">
  <div *ngIf = " shipments.alert == 'Warning' ">
  
  <div *ngFor = "let shipment of shipments.shipments">
  <table class="table table-bordered">
  <thead>
  <tr>
  <th>Id</th>
  <th>Pick Up Date</th>
  <th> Origin Address</th>
  <th> Destination Address</th>
  <th> Commodity </th>
  <th>  Weight </th>
  </tr>
  </thead>
<tbody>
    <tr> 
     <td> {{shipment.shipmentId}}</td>
     <td> {{shipment.pickUpDate.month}}/{{shipment.pickUpDate.dayOfMonth}}/{{shipment.pickUpDate.year}}, {{shipment.pickUpDate.hour}}:{{shipment.pickUpDate.minute}}</td>
     <td> {{shipment.origin.street}} <br> {{shipment.origin.city}}, {{shipment.origin.state}} </td>
     <td>{{shipment.destination.street}} <br> {{shipment.destination.city}}, {{shipment.destination.state}}</td>
     <td> {{shipment.commodity}}</td>
     <td> {{shipment.weight}}</td>
     </tr>
     </tbody>
 </table>
  </div>
  </div>
  </div>

  
  <div *ngFor = "let shipments of data">
  <div *ngIf = " shipments.alert == 'Danger' ">
  
      <div *ngFor = "let shipment of shipments.shipments">
  <table class="table table-bordered">
  <thead>
  <tr>
  <th>Id</th>
  <th>Pick Up Date</th>
  <th> Origin Address</th>
  <th> Destination Address</th>
  <th> Commodity </th>
  <th>  Weight </th>
  </tr>
  </thead>
<tbody>
    <tr> 
     <td> {{shipment.shipmentId}}</td>
     <td> {{shipment.pickUpDate.month}}/{{shipment.pickUpDate.dayOfMonth}}/{{shipment.pickUpDate.year}}, {{shipment.pickUpDate.hour}}:{{shipment.pickUpDate.minute}}</td>
     <td> {{shipment.origin.street}} <br> {{shipment.origin.city}}, {{shipment.origin.state}} </td>
     <td>{{shipment.destination.street}} <br> {{shipment.destination.city}}, {{shipment.destination.state}}</td>
     <td> {{shipment.commodity}}</td>
     <td> {{shipment.weight}}</td>
     </tr>
     </tbody>
  </table>
  </div>
  </div>
  `,
  styles: []
})
export class AppComponent {
  data: any = null;
  constructor(private _http: Http) {

    this.shipmentConsume();
  }
  shipmentConsume() {
    return this._http.get('http://localhost:8087/shipments').map((res: Response) => res.json()).subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      });
  }



}
