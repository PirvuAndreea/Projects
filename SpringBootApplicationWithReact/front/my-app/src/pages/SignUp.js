import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "../axios";
import { Grid } from "@material-ui/core";
import SuccesAlert from "./SuccesAlert"
import { Link } from 'react-router-dom';
import Verification from "./Verification";

class SignUp extends React.Component {
    constructor(){
        super();
        this.state = {
            email:"",
            username:"",
            password:"",
            alert_message:"",

            errors: {
                username: '',
                password: '',
                email:'',
              },
              
            invalid : false,
            exist : false,
          

        };
        
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

         
     };

     onSubmitFun = event => {
         event.preventDefault();
         if(this.state.username.length > 2 && this.state.password.length>2 && this.validEmailRegex.test(this.state.email) ){
         let UserDto = {
             //trebuie sa se numeasca la fel ca in dto
             username:this.state.username,
             password: this.state.password,
             email: this.state.email
            }
         axiosInstance.post("/signup", UserDto)
             .then(res =>{
                 console.log( res.data);
                 UserDto=res.data;
                 console.log(res.data);
                 this.setState({
                     alert_message:"success"
                 })
                 localStorage.setItem("COD", res.data.codactivare)
                 localStorage.setItem("EMAIL", res.data.email);
                 

                 
            this.props.history.push("/verification")
               

             }).catch(error => {
                this.setState({
                    exist:true,
                });
                console.log(this.state.exist);
                 console.log(error);
             })
            }
            else
            {
                this.setState({
                    invalid:true,
                })
            }


     }

    render() {
        return (
            <Container maxWidth="sm">
                <div>
                    <Grid>
                       
                        <form onSubmit={this.onSubmitFun}>
                        <TextField
                                variant="outlined"
                                margin="normal"
                                required
                                fullWidth
                                id="email"
                                label="E-mail"
                                type="email"
                                name="email"
                                autoComplete="string"
                                onChange={this.handleInput}
                                autoFocus
                            />

                            {this.state.errors.email.length > 0 &&
                                <span className='error'>{this.state.errors.email}</span>}



                            <TextField
                                variant="outlined"
                                margin="normal"
                                required
                                fullWidth
                                id="username"
                                label="Username"
                                name="username"
                                autoComplete="string"
                                onChange={this.handleInput}
                                autoFocus
                            />

                        {this.state.errors.username.length > 0 &&
                                <span className='error'>{this.state.errors.username}</span>}
                            <TextField
                                variant="outlined"
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                onChange={this.handleInput}
                                autoComplete="current-password"
                            />
                            
                            {this.state.errors.password.length > 0 &&
                                <span className='error'>{this.state.errors.password}</span>}
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                            >
                                Sign Up
                
                </Button>
                
                
                
                        </form>
                        {this.state.alert_message==="success" ? <SuccesAlert/> : null}
                        {this.state.invalid === true ? <h2>Format invalid!</h2>:null}
                        {this.state.exist === true ? <span>Acest cont exista deja!</span>:null}

                    </Grid>
                </div>
               
            </Container>
        );
    }


}
export default SignUp;