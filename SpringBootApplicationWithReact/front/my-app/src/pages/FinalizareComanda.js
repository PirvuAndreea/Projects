import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class FinalizareComanda extends React.Component {


    constructor() {
        super();
        this.state = {

            nume: "",
            prenume: "",
            oras: "",
            adresa: "",
            email: "",
            nrtelefon: "",
            codpostal: "",
            ComandaSucces: {
                id: 0,
                prettotal: 0,


            },
            displayFinal: false,
            errors: {
                nume: "",
                prenume: "",
                oras: "",
                adresa: "",
                email: "",
                nrtelefon: "",
                codpostal: "",

            },

            invalid: false,
        }


    }

    validEmailRegex =
        RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);


    displayFinal = () => {
        this.setState({
            displayFinal: !this.state.displayFinal
        })
        console.log("Buton")
        console.log(this.state.displayFinal)

    }

    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        let errors = this.state.errors;
        switch (name) {
            case 'nume':
                errors.nume =
                    value.length < 2
                        ? 'Last Name must be 2 characters long!'
                        : '';
                break;
            case 'email':
                errors.email =
                    this.validEmailRegex.test(value)
                        ? ''
                        : 'Email is not valid!';
                break;

            case 'prenume':
                errors.prenume =
                    value.length < 2
                        ? 'First Name must be 2 characters long!'
                        : '';
                break;
            case 'adresa':
                errors.adresa =
                    value.length < 3
                        ? 'Adress must be 3 characters long!'
                        : '';
                break;

            case 'oras':
                errors.oras =
                    value.length < 3
                        ? 'City must be 3 characters long!'
                        : '';
                break;

            case 'nrtelefon':
                errors.nrtelefon =
                    value.length < 10
                        ? 'Phone number must be 10 characters long!'
                        : '';
                break;

            case 'codpostal':
                errors.codpostal =
                    value.length < 5
                        ? 'Postal code must be 5 characters long!'
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
        if(this.state.nume.length > 1 && this.state.prenume.length>1 && this.validEmailRegex.test(this.state.email) && this.state.adresa.length>2
        && this.state.oras.length > 2 && this.state.nrtelefon.length>9 && this.state.codpostal.length > 4 ){
        let comanda = {

            nume: this.state.nume,
            prenume: this.state.prenume,
            oras: this.state.oras,
            adresa: this.state.adresa,
            email: this.state.email,
            nrtelefon: this.state.nrtelefon,
            codpostal: this.state.codpostal



        }
        //this.props.history.push("/ListaUser")


        axiosInstance.post("http://localhost:8080/comanda/save", comanda)
            .then(
                res => {
                    console.log(res.data)

                    comanda = res.data;
                    console.log(res.data);
                    const val = res.data;
                    this.setState({
                        ComandaSucces: val
                    });
                    console.log(this.state.ComandaSucces);

                }
            )
            .catch(error => {
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


        if (localStorage.getItem("ROLE") === "USER") {

            return (


                <React.Fragment>


                    <form onSubmit={this.handleSubmit}>
                        <Typography variant="h6" color="textPrimary" component="h6">
                            Finalizeaza comanda
            </Typography>
                        <div>




                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Nume:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Nume"
                                    name="nume"
                                    placeholder="nume"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.nume.length > 0 &&
                                <span className='error'>{this.state.errors.nume}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Prenume:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Prenume"
                                    name="prenume"
                                    placeholder="prenume"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.prenume.length > 0 &&
                                <span className='error'>{this.state.errors.prenume}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Oras:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Oras"
                                    name="oras"
                                    placeholder="oras"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.oras.length > 0 &&
                                <span className='error'>{this.state.errors.oras}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Adresa:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Adresa"
                                    name="adresa"
                                    placeholder="adresa"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.adresa.length > 0 &&
                                <span className='error'>{this.state.errors.adresa}</span>}
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
                                    label="E-mail"
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
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Numar telefon:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Nr telefon"
                                    name="nrtelefon"
                                    placeholder="nrtelefon"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.nrtelefon.length > 0 &&
                                <span className='error'>{this.state.errors.nrtelefon}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Cod postal:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Cod postal"
                                    name="codpostal"
                                    placeholder="codpostal"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.codpostal.length > 0 &&
                                <span className='error'>{this.state.errors.codpostal}</span>}


                        </div>
                       

                        <div id="buttons">
                            <Button
                                onClick={() => {

                                    //window.location.href = "/ListaUser"
                                    localStorage.setItem("COUNT", 0)
                                    this.displayFinal()

                                }}
                                variant="contained"
                                color="secondary"
                                id="create"
                                type="submit"
                            >
                                Finalizare
              </Button>



              {this.state.invalid === true ? <h2>Format invalid!</h2>:null}
                        </div>

                    </form>

                    {this.state.displayFinal && this.state.ComandaSucces.prettotal !== 0 && this.state.ComandaSucces.id !== 0 ?
                        <div>
                            <h1> Ati finalizat comanda cu succes</h1>
                            <p>Totalul comenzii: {this.state.ComandaSucces.prettotal}</p>
                            <p>Comanda cu numarul {this.state.ComandaSucces.id} a fost plasata!</p>
                        </div>

                        : null}
                </React.Fragment>



            )
        }
        else {
            throw new Error("Doar userul are acces");
        }




    }




}

export default FinalizareComanda;