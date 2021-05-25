import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "../axios";
import { Grid } from "@material-ui/core";


class ResetPassword extends React.Component {
    constructor() {
        super();
        this.state = {
            email: 0,
            password: "",
            confirmPassword: "",
            displayError: false,
            invalid: false,
            errors: {
                password: '',
                confirmPassword: '',
            },

        };
    }



    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        let errors = this.state.errors;
        switch (name) {
            case 'password':
                errors.password =
                    value.length < 3
                        ? 'Password must be 3 characters long!'
                        : '';
                break;
            case 'confirmPassword':
                errors.confirmPassword =
                    value.length < 3
                        ? 'Password must be 3 characters long!'
                        : '';
                break;


        }
        this.setState({ errors, [name]: value }, () => {
            console.log(errors)
        })
    };




    onSubmitFun = event => {
        event.preventDefault();
        if (this.state.password.length > 2 && this.state.confirmPassword.length > 2) {
            let dto = {
                email: localStorage.getItem("EMAIL"),
                password: this.state.password,
                confirmPassword: this.state.confirmPassword,
            }
            axiosInstance.put("/user/resetPassword", dto)
                .then(res => {

                    console.log(res.data);
                    if (this.state.password === this.state.confirmPassword) {
                        this.props.history.push("/log-in");
                        localStorage.setItem("FORGOT", false);
                        localStorage.removeItem("FORGOT");
                    }
                    else {
                        this.setState({
                            displayError: true
                        });
                    }

                }).catch(error => {
                    console.log(error);
                })
        }
        else {
            this.setState({
                invalid: true,
            })
        }

    }

    render() {
        if (localStorage.getItem("FORGOT") === "true") {
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
                                    id="password"
                                    label="New Password"
                                    type="password"
                                    name="password"
                                    autoComplete="string"
                                    onChange={this.handleInput}
                                    autoFocus
                                />
                                {this.state.errors.password.length > 0 &&
                                    <span className='error'>{this.state.errors.password}</span>}
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="confirmPassword"
                                    label="Confirm New Password"
                                    type="password"
                                    id="confirmPassword"
                                    onChange={this.handleInput}
                                    autoComplete="current-password"
                                />
                                {this.state.errors.confirmPassword.length > 0 &&
                                    <span className='error'>{this.state.errors.confirmPassword}</span>}
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    color="primary"
                                >
                                    Resetare parola
                    </Button>
                            </form>

                        </Grid>
                    </div>
                    {this.state.displayError === true ?
                        <div>

                        </div>
                        : null}

                    {this.state.invalid === true ? <h2>Format invalid!</h2> : null}



                </Container>
            );

        }
        else {
            throw new Error("Nu exista acces pe aceasta pagina");
        }
    }


}
export default ResetPassword;