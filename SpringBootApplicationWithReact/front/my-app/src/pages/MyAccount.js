import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import { Grid } from "@material-ui/core";
import Container from "@material-ui/core/Container";



class MyAccount extends React.Component {




    constructor() {
        super();
        this.state = {
            id: localStorage.getItem("USER_ID"),
            username: "",
            password: "",
            email: "",
            codactivare: 0,
            rol: "",
            enable: false,

        }


    }


    componentDidMount() {
        axiosInstance.get("http://localhost:8080/user/" + this.state.id)
            .then(res => {
                let user = res.data;
                this.setState({
                    id: user.id,
                    username: user.username,
                    password: user.password,
                    email: user.email,
                    codactivare: user.codactivare,
                    rol: user.rol,
                    enable: user.enable


                });

                console.log(res.data)
            }

            )
            .catch(error => {
                console.log(error)
            })
    }


    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
    }

    handleSubmit = event => {
        event.preventDefault();
        let u = {
            id: this.state.id,
            username: this.state.username,
            password: this.state.password,
            email: this.state.email,
            codactivare: this.state.codactivare,
            rol: this.state.rol,
            enable: this.state.enable


        }
        this.props.history.push("/myAccount")


        axiosInstance.put("http://localhost:8080/user/update1", u)
            .then(
                res => {
                    console.log(res.data)
                    console.log(res.data.mesaj)
                    u = res.data;
                    console.log(res.data);

                }
            )
            .catch(error => {
                console.log(error)
            });
    }





    render() {




        return (


            <React.Fragment>

                <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        Edit
            </Typography>
                    <div>

                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >

                            </Typography>
                            <TextField
                                required={true}
                                type="hidden"
                                value={this.state.id}
                                id="required"

                                name="id"
                                placeholder="id"
                                onChange={this.handleInput}
                                margin="normal"

                                autoComplete="off"
                            />
                        </div>


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
                                value={this.state.username}
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
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >

                            </Typography>
                            <TextField
                                required={true}
                                type="hidden"
                                value={this.state.password}
                                id="required"

                                name="password"
                                placeholder="password"
                                onChange={this.handleInput}
                                margin="normal"

                                autoComplete="off"
                            />
                        </div>
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
                                value={this.state.email}
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

                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >

                            </Typography>
                            <TextField
                                required={true}
                                type="hidden"
                                value={this.state.codactivare}
                                id="required"

                                name="codactivare"
                                placeholder="codactivare"
                                onChange={this.handleInput}
                                margin="normal"

                                autoComplete="off"
                            />
                        </div>


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >

                            </Typography>
                            <TextField
                                required={true}
                                type="hidden"
                                value={this.state.rol}
                                id="required"

                                name="rol"
                                placeholder="rol"
                                onChange={this.handleInput}
                                margin="normal"

                                autoComplete="off"
                            />
                        </div>


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >

                            </Typography>
                            <TextField
                                required={true}
                                type="hidden"
                                value={this.state.enable}
                                id="required"

                                name="enable"
                                placeholder="enable"
                                onChange={this.handleInput}
                                margin="normal"

                                autoComplete="off"
                            />
                        </div>

                    </div>
                    <div id="buttons">
                        <Button
                            onClick={() => {

                                window.location.href = "/myAccount"


                            }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                            Update
              </Button>
                    </div>
                </form>
                <br></br>
                <Button
                    onClick={() => {

                        window.location.href = "/changePassword"


                    }}
                    variant="contained"
                    color="secondary"
                    id="create"
                    type="submit"
                >
                    Schimba parola
              </Button>
            </React.Fragment>


        )
    }



}

export default MyAccount;