import React from 'react';
import { Container, Nav } from 'react-bootstrap';
import { Route, Link, BrowserRouter as Router, Routes } from 'react-router-dom';

const Home = () =>
{
  return(

    <Container>


    <h1>
      <Nav.Link as={Link} to="/zadaci">Zadaci</Nav.Link>
    </h1>


    
    </Container>
  )


}

export default Home