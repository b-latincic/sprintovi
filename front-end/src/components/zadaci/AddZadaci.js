
import React, { useEffect, useState } from "react";
import { Button, Container, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import SprintAxios from "../../apis/SprintAxios";

const AddZadaci = () => {

  let emptyZadatak = {
    ime: '',
    zaduzeni: '',
    bodovi: -1,
    stanjeId: -1,
    sprintId: -1
  }


  const[zadatak, setZadatak] = useState(emptyZadatak)
  const[stanja, setStanja] = useState([])
  const[sprintovi, setSprintovi] = useState([])

  const navigate = useNavigate()


  const getStanja = () => {
    SprintAxios.get("/stanja")
    .then(res => {
      console.log(res.data);
      setStanja(res.data)
    })
    .catch(error => {
      console.log(error);
    })
  }

  const getSprintovi = () => {
    SprintAxios.get("/sprintovi")
    .then(res => {
      console.log(res.data);
      setSprintovi(res.data)
    })
    .catch(error => {
      console.log(error);
    })
  }


  useEffect(() => {
    getStanja()
    getSprintovi()
  }, [])


  // const handleChange = (e) => {
  //   let zadatakDodavanje = {...zadatak}

  //   const name = e.target.name
  //   const value = e.target.value

    
  //   zadatakDodavanje[name] = value
  //   setZadatak(zadatakDodavanje)

  // }



  const onImeChange = (e) => {
    let ime = e.target.value
 
    setZadatak({
      ime: ime,
      zaduzeni: zadatak.zaduzeni,
      bodovi: zadatak.bodovi,
      stanjeId: zadatak.stanjeId,
      sprintId: zadatak.sprintId
    })
  }

  const onZaduzeniChange = (e) => {
    let zaduzeni = e.target.value

    setZadatak({
      ime: zadatak.ime,
      zaduzeni: zaduzeni,
      bodovi: zadatak.bodovi,
      stanjeId: zadatak.stanjeId,
      sprintId: zadatak.sprintId
    })
  }

  const onBodoviChange = (e) => {
    let bodovi = e.target.value

    setZadatak({
      ime: zadatak.ime,
      zaduzeni: zadatak.zaduzeni,
      bodovi: bodovi,
      stanjeId: zadatak.stanjeId,
      sprintId: zadatak.sprintId
    })
  }

  
  const stanjeSelectionChange = (e) => {
    let stanjeId = e.target.value
   
    setZadatak({
      ime: zadatak.ime,
      zaduzeni: zadatak.zaduzeni,
      bodovi: zadatak.bodovi,
      stanjeId: stanjeId,
      sprintId: zadatak.sprintId
    })
  }

  const sprintSelectionChange = (e) => {
    let sprintId = e.target.value

    setZadatak({
      ime: zadatak.ime,
      zaduzeni: zadatak.zaduzeni,
      bodovi: zadatak.bodovi,
      stanjeId: zadatak.stanjeId,
      sprintId: sprintId
    })

  }



  const create = () => {

    
    let params = {
      "ime": zadatak.ime,
      "zaduzeni": zadatak.zaduzeni,
      "bodovi": zadatak.bodovi,
      "stanjeId": zadatak.stanjeId,
      "sprintId": zadatak.sprintId
    }
    console.log(params);
    SprintAxios.post("/zadaci", params)
    .then(res => { 
      console.log(res);
      alert("Uspesno dodavanje!")
      navigate("/zadaci")
      })
    .catch(error => {
      alert("Greska")
    })

  }
  






return(
  <Container style={{paddingTop:"10px", paddingLeft:"10px"}}>
   <Row style={{marginBottom:"20px"}} className="justify-content-center">
  
  <Form style={{width: "50%"}}>
      <Form.Group>
        <Form.Label htmlFor="">Ime zadatka:</Form.Label>
        <Form.Control type="text" name="ime" onChange={(e) => onImeChange(e)}></Form.Control>
     </Form.Group>
     <Form.Group>
    <Form.Label>Zaduženi</Form.Label>
    <Form.Control type="text" name="zaduzeni" onChange={(e) => onZaduzeniChange(e)}></Form.Control>
    </Form.Group>    
    <Form.Group>
    <Form.Label>Bodovi</Form.Label>
    <Form.Control type="number" name="bodovi" onChange={(e) => onBodoviChange(e)}></Form.Control>
    </Form.Group>     
    <Form.Group>
    <Form.Label>Stanje</Form.Label>
    <Form.Control type="select" as="select" name="stanjeId" onChange={(e) => stanjeSelectionChange(e)}>
      <option value={-1}></option>/
      {stanja.map((el, i) => {
          return <option key={el.id} value={el.id}>{el.ime}</option>
       })}
    </Form.Control>
    </Form.Group> 
    <Form.Group>    
    <Form.Label>Sprint</Form.Label>
    <Form.Control type="select" as="select" name="stanjeId" onChange={(e) => sprintSelectionChange(e)}> 
    <option value={-1}></option>
      {sprintovi.map((el, i) => {
          return <option key={el.id} value={el.id}>{el.ime}</option>
       })}
    </Form.Control>
    </Form.Group>
    <Form.Group>
    <Button className="button button-navy" style={{marginTop: "10px", marginBottom: "10px"}}  onClick={create}>Kreiraj</Button>
    </Form.Group>
    </Form>
    </Row> 
  </Container>
)

}


export default AddZadaci