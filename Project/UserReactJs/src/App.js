import './index.css';
//import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import { useState } from "react";
import FetchData from './FetchData';
import Menu from './Menu';
function App() {

  const[userName, setUserName] = useState('');
  const[password, setPassword] = useState('');
  const[check, setCheck] = useState(0);

  const { data: user, isPending, error} = FetchData('http://localhost:4000/user');
   
  const handleClick = (e) =>{
    e.preventDefault();
    user.forEach(element => {
      if(element.userName===userName && element.userPassword===password){
        console.log("You have successfully logged in");
        setCheck(1);
      }
    });    
  }
   
  if(check===1){
    return (
      <div>
        <Menu setCheck={setCheck}/>
      </div>); 
  }



  return (
    <div className="Create">
      <h2>Login</h2>
        <form onSubmit={(e) => handleClick(e)}>
          <label>UserName</label>

            <input
              type="text"
              required 
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
            />
          <label>Password</label>
            <input
              type="text"
              required 
              value={password}
              onChange={(e)=>setPassword(e.target.value)}
            />
            {/* This is a anonymous function */}
            <button type='submit'>login</button>
            </form>
    </div>
    );
}

export default App;

