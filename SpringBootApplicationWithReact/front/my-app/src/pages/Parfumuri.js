import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField, Checkbox } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import Filter from '../components/Filter';
import EditIcon from "@material-ui/icons/Edit";
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";

class Parfumuri extends React.Component {




    constructor() {
        super();
        this.state = {
            value: 1,
            parfumuri: [],
            filteredProducts: [],
            filtered: [],
            review: {
                id: 0,
                autor0: "Andreea"
            },
            idParfum: 0,
            // idReview : 0,
            autor: "",
            mesaj: "",

            idParf: "",
            displayDetails: false,
            ProdusComandaSucces: {
                idComanda: 0,
            },

        }
        this.handleChangeSort = this.handleChangeSort.bind(this)
        this.handleChangeSize = this.handleChangeSize.bind(this)
        this.buttonClicked = this.buttonClicked.bind(this)

    }


    ceva(idd) {
        this.setState({ idParf: idd });
    }


    connect() {
        const URL = "http://localhost:8080/socket";
        const websocket = new SockJS(URL);
        const stompClient = Stomp.over(websocket);
        stompClient.connect({}, frame => {
            console.log("Conectat la " + frame);
            stompClient.subscribe("/topic/socket/parfum", notification => {
                let message = notification.body;
                console.log(message);
                alert(message);
                axiosInstance.get("http://localhost:8080/parfum")
                    .then(res => {
                        const val = res.data;
                        this.setState({
                            parfumuri: val,


                        })
                    });

            })
        })

    }

    buttonClicked(event) {
        this.setState({ value: this.state.value + 1 });
        localStorage.setItem("COUNT", this.state.value);
    }


    componentDidMount() {

        this.connect();
        axiosInstance.get("http://localhost:8080/parfum")
            .then(res => {
                const val = res.data;
                this.setState({
                    parfumuri: val,


                });
                console.log(val);
                console.log(this.state.parfumuri)
            }

            )
            .catch(error => {
                console.log(error)
            })

        axiosInstance.get("http://localhost:8080/review/" + this.state.review.autor0)
            .then(res => {
                const val = res.data;
                this.setState({
                    review: val
                });
                console.log(val);
                console.log(this.state.review)
            }

            )
            .catch(error => {
                console.log(error)
            })
    }


    displayDetails = () => {
        this.setState({
            displayDetails: !this.state.displayDetails
        })
        console.log("Buton")
        console.log(this.state.displayDetails)

    }

    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
    }

    handleSubmit2 = event => {

        this.props.history.push("/addReview")



    }

    handleSubmit1 = event => {

        event.preventDefault();

        let ProdusComanda = {
            //trebuie sa se numeasca la fel ca in java in dto

            idParfum: this.state.idParf,
            idUser: localStorage.getItem("USER_ID"),
            cantitate: 0,
            //reviewID:this.state.idReview

        }
        axiosInstance.put("http://localhost:8080/produsComanda/add", ProdusComanda)
            .then(
                res => {

                    ProdusComanda = res.data;
                    this.setState({
                        ProdusComandaSucces: res.data
                    });
                    console.log(res.data);
                    console.log(this.state.ProdusComandaSucces);
                    //localStorage.setItem("ProdusID", this.state.ProdusComandaSucces.idComanda)
                }
            )
            .catch(error => {
                console.log(error)
            });
    }

    handleSubmit3 = event => {

        event.preventDefault();

        let ParfumAddition = {
            //trebuie sa se numeasca la fel ca in java in dto


            idUser: localStorage.getItem("USER_ID"),
            idParfum: localStorage.getItem("IDPARFUM"),


        }
        axiosInstance.put("http://localhost:8080/user/addWishList", ParfumAddition)
            .then(
                res => {

                    ParfumAddition = res.data;

                    console.log(res.data);


                }
            )
            .catch(error => {
                console.log(error)
            });
    }

    handleChangeSort(event) {
        this.setState({ sort: event.target.value });
        this.listProducts();

    }

    handleChangeSize(event) {
        this.setState({ size: event.target.value });
        this.listProducts();

    }



    listProducts() {
        this.setState(state => {
            if (state.sort !== " ") {
                state.parfumuri.sort((a, b) => (state.sort === "Lowest") ? (a.pret > b.pret ? 1 : -1) : (a.pret < b.pret ? 1 : -1))
            } else if (state.sort === " ") {
                state.parfumuri.sort((a, b) => (a.id > b.id ? 1 : -1));

            }
            if (state.size !== " ") {
                if (state.size === "Armani") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Armani") }
                }
                else if (state.size === "Cristian Dior") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Cristian Dior") }
                }
                else if (state.size === "Carolina") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Carolina") }
                }
            }
            else {
                window.location.reload();

            }


            return { parfumuri: state.parfumuri };

        })
    }

    render() {



        return (



            <React.Fragment>
                <div>
                    <hr />
                    <Filter size={this.state.size} sort={this.state.sort} handleChangeSize={this.handleChangeSize}
                        handleChangeSort={this.handleChangeSort} count={this.state.parfumuri.length} />

                    <hr />
                </div>



                <List>

                    {this.state.parfumuri.map(parfum => (


                        <ListItem>

                            <img src={parfum.filename} alt={parfum.numeparfum} height="100" width="100" />

                            <ListItemText primary={parfum.id + " " + parfum.numeparfum + " " + parfum.producator + " " +
                                parfum.pret + " "}
                                secondary={"Review-uri: " + parfum.reviewList.map(review => review.mesaj + " ")} />


                            {this.state.displayDetails ?

                                <TableBody>

                                    <TableRow  >
                                        <TableCell align="right">Producator : {parfum.producator}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">An fabricatie : {parfum.anfabricatie}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Tara : {parfum.tara}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Genul parfumului : {parfum.genparfum}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Continut : {parfum.continut}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Descriere : {parfum.descriere}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Pret : {parfum.pret}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Cantitate : {parfum.cantitate}</TableCell>
                                    </TableRow>
                                    <TableRow >
                                        <TableCell align="right">Tip : {parfum.tip}</TableCell>
                                    </TableRow>

                                </TableBody>

                                : null}




                            <Button onClick={() => this.displayDetails()}>
                                <EditIcon /> Show more
                             </Button>

                             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


                            <form onSubmit={this.handleSubmit1}>
                                <Button
                                    onClick={() => {
                                        // if(localStorage.getItem("ROLE") === "USER"){
                                        // this.buttonClicked();

                                        // } 
                                        this.ceva(parfum.id);
                                    }}

                                    variant="contained"
                                    color="secondary"
                                    id="create"
                                    type="submit" >
                                    Add to cart
                            </Button>
                            </form>

                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                            <form onSubmit={this.handleSubmit2}>
                                <Button
                                    onClick={() => {
                                        localStorage.setItem("IDPARFUM", parfum.id)


                                    }}

                                    variant="contained"
                                    color="secondary"
                                    id="create"
                                    type="submit" >
                                    Add review
                            </Button>
                            </form>

                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            {localStorage.getItem("ROLE") === "USER" ?
                            
                            <form onSubmit={this.handleSubmit3}>
                                <Button
                                    onClick={() => {
                                        localStorage.setItem("IDPARFUM", parfum.id)


                                    }}

                                    variant="contained"
                                    color="secondary"
                                    id="create"
                                    type="submit" >
                                    Add in Wish List
                            </Button>
                            </form>
                            :null}


                        </ListItem>

                    ))}
                </List>



            </React.Fragment>



        )



    }
}

export default Parfumuri;