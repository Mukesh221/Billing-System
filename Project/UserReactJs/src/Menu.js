import FetchData from './FetchData';
import { useState } from 'react';
const  Menu = (props) => {
    const {data: menu, isPending, error} = FetchData('http://localhost:4000/menu');
    const[cost, setCost] = useState(0);
    
    function selectitem(temp){
        setCost(cost => {
            return cost+temp;
        });    
    }

    var order = {};
    let today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; 
    var yyyy = today.getFullYear();
    if(dd<10)  dd='0'+dd;
    if(mm<10)  mm='0'+mm;
      
    today = yyyy+'-'+mm+'-'+dd;
    order.billDate =  today;
    order.totalAmount = cost;
     
    function addtodata(){
        fetch('http://localhost:4000/bill', {
            method : 'POST',
            headers :{ 'Content-Type':'application/json'},
            body: JSON.stringify(order)
        }).then( () => {
            console.log("item is added");
        })
    }
    return (
        <div className="MenuList">
           <h3>Please see the menu below</h3>
           {menu && menu.map(element => (
               <div className="SeeMenu" key={element.menuId}>
                    <p>Item Name : {element.itemName}</p>
                    <p>Price : {element.itemCost}</p>
                     
                    {<button onClick={(e)=>{selectitem(element.itemCost)}}>Select this item</button>}
                    
                </div>
                     
           ))}
            
           <h1><p>Your final bill is {cost}</p></h1> 
           <p>Please Click on the "order it!!" button to order</p>
           {<button onClick={(e)=>{addtodata()}}>Order It!!</button>}
           {<button onClick={()=>props.setCheck(0)}>Logout</button>}
        </div>
        
    );
}
 
export default Menu;