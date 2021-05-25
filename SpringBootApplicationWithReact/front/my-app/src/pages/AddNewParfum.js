import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';


class AddNewParfum extends React.Component {




    constructor() {
        super();
        this.state = {
            id: "",
            numeparfum: "",
            producator: "",
            anfabricatie: "",
            tara: "",
            genparfum: "",
            continut: "",
            descriere: "",
            pret: "",
            cantitate: "",
            tip: "",
            filename: "",
            incos: "",
            reviewList: [],


            errors: {
                numeparfum: "",
                producator: "",
                anfabricatie: 0,
                tara: "",
                genparfum: "",
                continut: "",
                descriere: "",
                pret: "",
                cantitate: "",
                tip: "",
                filename: "",

            },
            invalid:false,




        }


    }





    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        let errors = this.state.errors;
        switch (name) {
            case 'numeparfum':
                errors.numeparfum =
                    value.length < 1
                        ? 'Nume parfum cannot be empty!'
                        : '';
                break;
            case 'producator':
                errors.producator =
                    value.length < 1
                        ? 'Producator cannot be empty!'
                        : '';
                break;

            case 'anfabricatie':
                errors.anfabricatie =
                    value > 2021
                        ? 'An fabricate must be less then 2021!'
                        : '';
                break;
            case 'tara':
                errors.tara =
                    value.length < 1
                        ? 'Tara cannot be empty!'
                        : '';
                break;
            case 'genparfum':
                errors.genparfum =
                    value.length < 1
                        ? 'Gen parfum cannot be empty!'
                        : '';
                break;
            case 'continut':
                errors.continut =
                    value.length < 1
                        ? 'Continut cannot be empty!'
                        : '';
                break;
            case 'descriere':
                errors.descriere =
                    value.length < 1
                        ? 'Descriere cannot be empty!'
                        : '';
                break;
            case 'pret':
                errors.pret =
                    value.length < 1
                        ? 'Pret cannot be empty!'
                        : '';
                break;
            case 'cantitate':
                errors.cantitate =
                    value < 1
                        ? 'Cantitate cannot be 0!'
                        : '';
                break;
            case 'tip':
                errors.tip =
                    value.length < 1
                        ? 'Tip cannot be empty!'
                        : '';
                break;
            case 'filename':
                errors.filename =
                    value.length < 1
                        ? 'Filename cannot be empty!'
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
        if(this.state.numeparfum.length > 0 && this.state.producator.length>0 && this.state.anfabricatie <2022 && this.state.tara.length > 0 &&
            this.state.genparfum.length > 0 && this.state.continut.length > 0 && this.state.descriere.length > 0 && this.state.pret.length > 0 
            && this.state.cantitate.length > 0 && this.state.tip.length > 0 && this.state.filename.length >0  ){
        let parf = {

            numeparfum: this.state.numeparfum,
            producator: this.state.producator,
            anfabricatie: this.state.anfabricatie,
            tara: this.state.tara,
            genparfum: this.state.genparfum,
            continut: this.state.continut,
            descriere: this.state.descriere,
            pret: this.state.pret,
            cantitate: this.state.cantitate,
            tip: this.state.tip,
            filename: this.state.filename,



        }
        this.props.history.push("/ListaParfumuri")


        axiosInstance.post("http://localhost:8080/parfum/save", parf)
            .then(
                res => {
                    console.log(res.data)
                    console.log(res.data.mesaj)
                    parf = res.data;
                    console.log(res.data);

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


        if (localStorage.getItem("ROLE") === "ADMIN") {

            return (


                <React.Fragment>

                    <form onSubmit={this.handleSubmit}>
                        <Typography variant="h6" color="textPrimary" component="h6">
                            Adauga un nou parfum
            </Typography>
                        <div>



                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Nume parfum:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Nume parfum"
                                    name="numeparfum"
                                    placeholder="numeparfum"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.numeparfum.length > 0 &&
                                <span className='error'>{this.state.errors.numeparfum}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Producator:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Producator"
                                    name="producator"
                                    placeholder="producator"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>

                            {this.state.errors.producator.length > 0 &&
                                <span className='error'>{this.state.errors.producator}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    An fabricatie:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="An fabricatie"
                                    name="anfabricatie"
                                    placeholder="anfabricatie"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.anfabricatie.length > 0 &&
                                <span className='error'>{this.state.errors.anfabricatie}</span>}



                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Tara:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Tara"
                                    name="tara"
                                    placeholder="tara"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.tara.length > 0 &&
                                <span className='error'>{this.state.errors.tara}</span>}

                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Gen parfum:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Gen parfum"
                                    name="genparfum"
                                    placeholder="genparfum"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.genparfum.length > 0 &&
                                <span className='error'>{this.state.errors.genparfum}</span>}

                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Continut:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Continut"
                                    name="continut"
                                    placeholder="continut"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.continut.length > 0 &&
                                <span className='error'>{this.state.errors.continut}</span>}

                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Descriere:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Descriere"
                                    name="descriere"
                                    placeholder="descriere"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.descriere.length > 0 &&
                                <span className='error'>{this.state.errors.descriere}</span>}

                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Pret:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Pret"
                                    name="pret"
                                    placeholder="pret"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.pret.length > 0 &&
                                <span className='error'>{this.state.errors.pret}</span>}


                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Cantitate:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Cantitate"
                                    name="cantitate"
                                    placeholder="cantitate"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.cantitate.length > 0 &&
                                <span className='error'>{this.state.errors.cantitate}</span>}


                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Tip:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Tip"
                                    name="tip"
                                    placeholder="tip"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.tip.length > 0 &&
                                <span className='error'>{this.state.errors.tip}</span>}
                            <div>
                                <Typography
                                    variant="subtitle2"
                                    color="textPrimary"
                                    component="h2"
                                >
                                    Filename:
                </Typography>
                                <TextField
                                    required={true}

                                    id="required"
                                    label="Filename"
                                    name="filename"
                                    placeholder="filename"
                                    onChange={this.handleInput}
                                    margin="normal"
                                    variant="outlined"
                                    autoComplete="off"
                                />
                            </div>
                            {this.state.errors.filename.length > 0 &&
                                <span className='error'>{this.state.errors.filename}</span>}






                        </div>
                        <div id="buttons">
                            <Button
                                onClick={() => {
                                    
                                    window.location.href = "/ListaParfumuri"
                                    

                                   


                                }}
                                variant="contained"
                                color="secondary"
                                id="create"
                                type="submit"
                            >
                                Adauga parfum
              </Button>
                        </div>
                    </form>
                    {this.state.invalid === true ? <h2>Format invalid!</h2>:null}
                    
                </React.Fragment>



            )
        }
        else {
            throw new Error("Doar administratorul are acces");
        }



    }




}

export default AddNewParfum;