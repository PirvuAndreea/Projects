import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "./axios";
import { Grid } from "@material-ui/core";
import SuccesAlert2 from './pages/SuccesAlert2'

class Login extends React.Component {
    constructor() {
        super();
        this.state = {
            username: "",
            password: "",
            loginSucces: {
                role: "",
                id: 0,
                enable: false
            },
            alert_message: "",
            errors: {
                username: '',
                password: '',
              },

            invalid : false,
            inexistent : false,
        };
    }



    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        let errors = this.state.errors;
        switch (name) {
            case 'username':
                errors.username =
                    value.length < 3
                        ? 'Username must be 3 characters long!'
                        : '';
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
            console.log(this.state.username.length)
        })


    };

    

    onSubmitFun = event => {
        event.preventDefault();

        if(this.state.username.length > 2 && this.state.password.length>2){
        
       
        let credentials = {
            username: this.state.username,
            password: this.state.password
        }
        axiosInstance.post("/login", credentials)
            .then(res => {
                const val = res.data;
                this.setState({
                    loginSucces: val
                });
                console.log("Succes");
                console.log(this.state.loginSucces);
                localStorage.setItem("ROLE", res.data.role);
                localStorage.setItem("USER_ID", res.data.id);
                localStorage.setItem("PERMISIUNE", res.data.enable);




                if (this.state.loginSucces.role === "USER" && this.state.loginSucces.enable === true) {
                    console.log("USER");
                    this.state.alert_message = "succes";
                    this.props.history.push("/parfumuri");
                    window.location.href = "/parfumuri"
                }

                if (this.state.loginSucces.role === "ADMIN" && this.state.loginSucces.enable === true) {
                    this.state.alert_message = "succes";
                    this.props.history.push("/administrator");
                    window.location.href = "/administrator"
                }
                else
                    if (this.state.loginSucces.enable === false) {
                        this.state.alert_message = "error";
                        console.log(this.state.alert_message);
                        throw new Error("Acest cont nu are acces");

                    }






            }).catch(error => {
                this.setState({
                    inexistent:true,
                });
                console.log(this.state.inexistent);
                console.log(error);
            })
        }
        else{
           this.setState({
               invalid:true,
           })

        }
       // console.log(this.state.invalid)

    }


    handleSubmit2 = event => {

        this.props.history.push("/forgotPassword")

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
                                Sign In
                    </Button>
                        </form>
                        {this.state.alert_message === "error" ? <SuccesAlert2 /> : null}
                       
                    </Grid>
                </div>

                <br>
                </br>
                <form onSubmit={this.handleSubmit2}>
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                    >
                        Forgot Password
                    </Button>
                </form>
                {this.state.invalid === true ? <h2>Format invalid!</h2>:null}
                {this.state.inexistent === true ? <span>Username or Password incorrect!</span>:null}
            </Container>
        );
    }


}
export default Login;