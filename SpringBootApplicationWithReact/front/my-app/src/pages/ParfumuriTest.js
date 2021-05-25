import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField, Checkbox, Box, Grid } from '@material-ui/core';
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
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import FavoriteIcon from '@material-ui/icons/Favorite';
import PersonIcon from '@material-ui/icons/Person';
import DeviceHubIcon from '@material-ui/icons/DeviceHub';
import AddShoppingCartIcon from '@material-ui/icons/AddShoppingCart';
import SortIcon from '@material-ui/icons/Sort';
import ShoppingBasketIcon from '@material-ui/icons/ShoppingBasket';
import HorizontalSplitOutlinedIcon from '@material-ui/icons/HorizontalSplitOutlined';
import CardHeader from '@material-ui/core/CardHeader';


class ParfumuriTest extends React.Component {




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

    addToCart = (product_id) => {



        let ProdusComanda = {
            //trebuie sa se numeasca la fel ca in java in dto

            idParfum: product_id,
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

    addToWishList = (product_id) => {



        let ParfumAddition = {
            //trebuie sa se numeasca la fel ca in java in dto


            idUser: localStorage.getItem("USER_ID"),
            idParfum: product_id,


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
                else if (state.size === "Paco Rabanne") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Paco Rabanne") }
                }
                else if (state.size === "Jean Paul Gaultier") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Jean Paul Gaultier") }
                }
                else if (state.size === "Thierry Mugler") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Thierry Mugler") }
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





                <Box width="80%" top={250} left={165} position="absolute" display="flex" >



                    <Grid container direction="row" justify="center" alignItems="center" spacing={1}>

                        {this.state.parfumuri.map(parfum => (

                            <Grid item xs sm md lg key={parfum.id}>

                                <Card style={{ backgroundColor: "oldlace ", height: "500px", width: "250px" }} cardObject={parfum.id} >

                                    <CardHeader
                                        // title = {product.name}
                                        // subheader={product.brand}
                                        title={<Typography style={{ fontSize: "20px", fontFamily: '"Apple Color Emoji"' }}> {parfum.numeparfum} </Typography>}
                                        subheader={<Typography style={{ fontSize: "16px", fontFamily: '"Apple Color Emoji"' }}> {parfum.producator} </Typography>}

                                    />

                                    <CardActionArea>
                                        <CardMedia
                                            component="img"
                                            height="250px"
                                            width="100px"
                                            image={parfum.filename}
                                        />
                                        <CardContent>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "20px", fontFamily: '"Apple Color Emoji"' }}>
                                                {parfum.pret + "€"}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "12px", fontFamily: '"Apple Color Emoji"' }}>
                                                {parfum.reviewList.map(review => review.mesaj + "\n")}
                                            </Typography>

                                        </CardContent>


                                    </CardActionArea>
                                    <CardActions style={{ justifyContent: 'center' }}>


                                        <IconButton onClick={() => this.displayDetails()}> <HorizontalSplitOutlinedIcon /> </IconButton>


                                        <IconButton aria-label="add to favorites" onClick={() => this.addToWishList(parfum.id)}> <FavoriteIcon /> </IconButton>


                                        <IconButton aria-label="add to basket" onClick={() => this.addToCart(parfum.id)}> <ShoppingBasketIcon /> </IconButton>



                                        <form onSubmit={this.handleSubmit2}>
                                            <Button style={{ fontSize: "10px" }}
                                                onClick={() => {
                                                    localStorage.setItem("IDPARFUM", parfum.id)


                                                }}
                                                alignItems="center"

                                                variant="contained"
                                                color="secondary"
                                                id="create"
                                                type="submit" >
                                                Add review
                                         </Button>
                                        </form>

                                    </CardActions>



                                </Card>

                                {this.state.displayDetails ?

                                    <Card style={{ backgroundColor: "oldlace ", height: "250px", width: "250px" }} cardObject={parfum.id}>
                                        <CardContent>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                An fabricatie:   {parfum.anfabricatie}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Tara : {parfum.tara}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Genul parfumului : {parfum.genparfum}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Continut : {parfum.continut}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Descriere : {parfum.descriere}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Cantitate : {parfum.cantitate}
                                            </Typography>
                                            <Typography gutterBottom variant="h6" component="h1" style={{ fontSize: "15px", fontFamily: '"Apple Color Emoji"' }}>
                                                Tip : {parfum.tip}
                                            </Typography>


                                        </CardContent>
                                    </Card>

                                    : null}
                            </Grid>

                        ))}

                    </Grid>

                </Box>


            </React.Fragment>



        )



    }
}

export default ParfumuriTest;