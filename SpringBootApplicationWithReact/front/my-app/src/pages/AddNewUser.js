import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class AddNewUser extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
        
         username:"",
         password:"",
         email:"",
         errors: {
            username: '',
            password: '',
            email:'',
          },
          
        invalid : false,
        exist : false,
         
        }

    
    }


    validEmailRegex = 
    RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);
    
    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        let errors = this.state.errors;
         switch (name) {
            case 'username':
                errors.username =
                    value.length < 3
                        ? 'Username must be 3 characters long!'
                        : '';
                break;
            case 'email': 
                errors.email = 
                  this.validEmailRegex.test(value)
                    ? ''
                    : 'Email is not valid!';
                break;

            case 'password':
                errors.password =
                    value.length < 3
                        ? 'Password must be 3 characters long!'
                        : '';
                break;
            default:
                break;
        }

        this.setState({ errors, [name]: value }, () => {
            console.log(errors)
        })
    }

     handleSubmit = event => {
         event.preventDefault();
         if(this.state.username.length > 2 && this.state.password.length>2 && this.validEmailRegex.test(this.state.email) ){
         let u = {
            
            username:this.state.username,
            password:this.state.password,
            email:this.state.email,
          
             
         }
        // this.props.history.push("/ListaUser")

         
         axiosInstance.post("http://localhost:8080/user/save", u)
         .then(
             res => {
                 console.log(res.data)
                 console.log(res.data.mesaj)
                 u = res.data;
                 console.log(res.data);
                 
             }
         )
         .catch(error => {
            this.setState({
                exist:true,
            });
             console.log(error)
         });
        }
        else
        {
            this.setState({
                invalid:true,
            })
        }
     }


   


     render() {
        

        if( localStorage.getItem("ROLE") === "ADMIN")
        {
        
        return (
            
           
            <React.Fragment>

                <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        Update User
            </Typography>
                    <div>
                       
                  


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Username:
                </Typography>
                            <TextField
                                required={true}
                               
                                id="required"
                                label="Username"
                                name="username"
                                placeholder="username"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        {this.state.errors.username.length > 0 &&
                                <span className='error'>{this.state.errors.username}</span>}
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Password:
                </Typography>
                            <TextField
                                required={true}
                              
                                id="required"
                                label="Password"
                                name="password"
                                placeholder="password"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        {this.state.errors.password.length > 0 &&
                                <span className='error'>{this.state.errors.password}</span>}
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                E-mail:
                </Typography>
                            <TextField
                                required={true}
                                
                                id="required"
                                label=" E-mail"
                                name="email"
                                placeholder="email"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                            
                           
                        </div>
                        {this.state.errors.email.length > 0 &&
                                <span className='error'>{this.state.errors.email}</span>}

                     
                       
                    </div>
                    <div id="buttons">
                        <Button
                        onClick={() => {
                          
                            window.location.href = "/ListaUser"
                           
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                            Adauga User
              </Button>
                    </div>
                </form>
                {this.state.invalid === true ? <h2>Format invalid!</h2>:null}
                {this.state.exist === true ? <span>Acest cont exista deja!</span>:null}
            </React.Fragment>
               
                
                    
        )
    }
    else
    {
        throw new Error("Doar administratorul are acces");
    }
                    
                    
                    
                    
    }




}

export default AddNewUser;