function getProizvod(id)
{
    return $.ajax("/WebShop/rest/proizvoidi/" + id);
}