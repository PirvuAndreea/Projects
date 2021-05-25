import logo from './logo.svg';
import './App.css';
import { Button } from '@material-ui/core';
import Link from '@material-ui/core/Link';
import Carousel from 'react-material-ui-carousel';
import { Paper } from '@material-ui/core'
import First from './First' ;
import LogIn from './LogIn';
import Navbar from './components/Navbar';
import SignUp from './pages/SignUp';
import CosProduct from './pages/CosProduct';
import Exit from './pages/Exit';
import Verification from './pages/Verification';
import Parfumuri from './pages/Parfumuri';
import AddReview from './pages/AddReview';
import AdministratorParf from './pages/AdministratorParf';
import UpdateParfum from './pages/UpdateParfum';
import Admin from './pages/Admin';
import AddNewParfum from './pages/AddNewParfum';
import ListUsers from './pages/ListUsers';
import UpdateUser from './pages/UpdateUser';
import AddNewUser from './pages/AddNewUser';
import Contact from './pages/Contact';
import FinalizareComanda from './pages/FinalizareComanda';
import WishList from './pages/WishList';
import ListaComenzi from './pages/ListComenzi';
import ResetPassword from './pages/ResetPassword';

import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from "react-router-dom";
import Home from './pages/Home';
import ListComenzi from './pages/ListComenzi';
import NavbarTest from './components/NavbarTest';
import ParfumuriTest from './pages/ParfumuriTest';
import ForgotPassword from './pages/ForgotPassword';
import MyAccount from './pages/MyAccount';
import ChangePassword from './pages/ChangePassword';


function App() {
  //const defaultRoute = window.location.pathname === "/" ? <Redirect to="/log-in" /> : undefined;
  return (

      // <div className="App">
      //   <header className="App-header">
      //     <img src={logo} className="App-logo" alt="logo" />
      //     <p>
      //       Edit <code>src/App.js</code> and save to reload.
      //     </p>
      //     <a
      //       className="App-link"
      //       href="https://reactjs.org"
      //       target="_blank"
      //       rel="noopener noreferrer"
      //     >
      //       Learn React

      //     </a>
      //   </header>
      // </div>
      
    <Router>
      <NavbarTest/>
      <Switch>
      <Route exact path = "/log-in" exact component={LogIn}/>
      <Route exact path = "/administrator" component = {Admin}/>
      <Route exact path = "/sign-up" component = {SignUp}/>
      <Route exact path = "/shopping" component = {CosProduct}/>
      <Route exact path = "/exit" component = {Exit}/>
      <Route exact path = "/verification" component = {Verification}/>
      <Route exact path = "/parfumuri" component = {ParfumuriTest}/>
      <Route exact path = "/addReview" component = {AddReview}/>
      <Route exact path = "/updateParfum" component = {UpdateParfum}/>
      <Route exact path = "/ListaParfumuri" component = {AdministratorParf}/>
      <Route exact path = "/AddNewProduct" component = {AddNewParfum}/>
      <Route exact path = "/ListaUser" component = {ListUsers}/>
      <Route exact path = "/updateUser" component = {UpdateUser}/>
      <Route exact path = "/AddNewUser" component = {AddNewUser}/>
      <Route exact path = "/" component = {Home}/>
      <Route exact path = "/contacts" component = {Contact}/>
      <Route exact path = "/finalizareComanda" component = {FinalizareComanda}/>
      <Route exact path = "/wishList" component = {WishList}/>
      <Route exact path = "/ListaComenzi" component = {ListComenzi}/>
      <Route exact path = "/forgotPassword" component = {ForgotPassword}/>
      <Route exact path = "/resetPassword" component = {ResetPassword}/>
      <Route exact path = "/myAccount" component = {MyAccount}/>
      <Route exact path = "/changePassword" component = {ChangePassword}/>
    

      
      
      
      
      </Switch>
    </Router>
    

   // <Router>
    //  <Switch>
    //    <Route exact path = "/log-in" component = {LogIn}/>
     //   <Route exact path = "/administrator" component = {First}/>
        
    //  </Switch>
    //  {defaultRoute}

    //</Router>
   
  
  );
}

export default App;
