create database JavaWebShop
go
use JavaWebShop
go
create table Kategorija
(
	KategorijaID int constraint pk_Kategorija primary key identity,
	Naziv nvarchar(50) not null
)

create table Proizvod
(
	ProizvodId int constraint pk_Proizvod primary key identity,
	IdKategorija int constraint fk_Kategorija foreign key references Kategorija(KategorijaID),
	Naziv nvarchar(50) not null,
	Cijena money not null,
	Slika nvarchar(200) not null,
	Opis nvarchar(50) not null
)

insert into Kategorija(Naziv)
values 
('Monitori'),
('Miševi'),
('Tipkovnice'),
('Igre'),
('Software')

--MONITORI
insert into Proizvod(IDKategorija, Naziv, Cijena, Opis, Slika)
values 
(1, 'DELL P2414H', 1789, 'Rezolucija 1920x1080', 'http://n0.static-elipso.com/images/xbig/105044.jpg'),
(1, 'ACER UM.WX0EE', 999, 'Rezolucija 1920x1080', 'http://n0.static-elipso.com/images/xbig/119379.jpg'),
(1, 'PHILIPS 226', 1049, 'Rezolucija 192x1080', 'http://n0.static-elipso.com/images/xbig/104031.jpg'),
(1, 'AOC E970SWN', 699, 'Rezolucija 1366x768', 'http://n0.static-elipso.com/images/xbig/105340.jpg')

--MISEVI
insert into Proizvod(IDKategorija, Naziv, Cijena, Opis, Slika)
values 
(2, 'LOGITECH M235', 149, 'optički, bežični', 'https://www.links.hr/content/images/thumbs/000/0007072_mis-logitech-m235-opticki-bezicni-crni-usb-101509080.jpg'),
(2, 'G.SKILL RIPJAWS MX780', 474.05, 'USB, 8200dpi', 'https://www.links.hr/content/images/thumbs/001/0010503_mis-gskill-ripjaws-mx780-rgb-8200dpi-usb-crni.jpeg'),
(2, 'GAMDIAS Ourea Optical', 189.05, 'USB, 2500dpi', 'https://www.links.hr/content/images/thumbs/001/0011126_mis-gamdias-ourea-optical-2500dpi-crni-usb.jpeg'),
(2, 'GENIUS NX-6510', 95.05, 'USB, bežični', 'https://www.links.hr/content/images/thumbs/000/0007059_mis-genius-nx-6510-usb-bezicni-bijela-tattoo-101506384.jpg'),
(2, 'GENIUS X-G300', 132.05, 'USB, optički, 2000dpi', 'https://www.links.hr/content/images/thumbs/000/0007023_mis-genius-x-g300-gaming-2000dpi-crni-usb-101503416.jpg'),
(2, 'SHARKOON Fireglider', 269, 'USB, laserski 3600dpi', 'http://n0.static-elipso.com/images/xbig/103015.jpg')

--TIPKOVNICE
insert into Proizvod(IDKategorija, Naziv, Cijena, Opis, Slika)
values 
(3, 'APPLE', 474.05, 'žičana, HR znakovi', 'https://www.links.hr/content/images/thumbs/000/0006915_tipkovnica-apple-zicna-hr-znakovi-mb110cr-b-101201058.jpg'),
(3, 'COOLERMASTER STORM QuickFire', 825.55, 'USB, mehanička, ENG znakovi', 'https://www.links.hr/content/images/thumbs/001/0011259_tipkovnica-coolermaster-storm-quickfire-tk-red-mehanicka-eng-usb.jpeg'),
(3, 'Das Keyboard 4 Professional', 1424.05, 'USB, UK + HR znakovi', 'https://www.links.hr/content/images/thumbs/000/0006934_tipkovnica-das-keyboard-4-professional-mx-blue-uk-hr-layout-usb-101201117.jpg'),
(3, 'G.SKILL Ripjaws KM780', 1424.05, 'USB, mehanička', 'https://www.links.hr/content/images/thumbs/000/0009494_tipkovnica-g-skill-ripjaws-km780-rgb-mehanicka-crna-usb-101201152.jpg'),
(3, 'MODECOM MC-8000 Volcano', 65.55, 'USB', 'https://www.links.hr/content/images/thumbs/000/0006929_tipkovnica-modecom-mc-8000-volcano-gaming-usb-101201106.jpg')

--IGRE
insert into Proizvod(IDKategorija, Naziv, Cijena, Opis, Slika)
values 
(4, 'FAR CRY PRIMAL', 299, 'Igra za PC', 'https://www.links.hr/content/images/thumbs/001/0013371_igra-za-pc-far-cry-primal-special-edition-650212451.jpg'),
(4, 'Need for Speed', 399, 'Igra za PS4', 'https://www.links.hr/content/images/thumbs/001/0013620_igra-za-ps4-need-for-speed-ps4.jpeg'),
(4, 'FIFA 16', 299, 'Igra za PC', 'https://www.links.hr/content/images/thumbs/000/0007965_igra-za-pc-fifa-16-nogometna-simulacija-650400040.jpg'),
(4, 'Assassins Creed Syndicate', 249, 'Igra za PS4', 'https://www.links.hr/content/images/thumbs/001/0013373_igra-za-sony-playstation-4-assassin-s-creed-syndicate-special-edition-650209038.jpg'),
(4, 'Dragon Age: Inquisition', 189.05, 'Igra za PS3', 'https://www.links.hr/content/images/thumbs/000/0007952_igra-za-playstation-3-dragon-age-inquisition-deluxe-650400008.jpg')

--SOFTWARE
insert into Proizvod(IDKategorija, Naziv, Cijena, Opis, Slika)
values 
(5, 'ADOBE Acrobat Pro DC', 4707.25, 'WIN/MAC trajna licenca', 'https://www.links.hr/content/images/thumbs/000/0007632_adobe-acrobat-pro-dc-win-mac-ie-licenca-elektronski-proizvod-trajna-licenca-250125080.jpg'),
(5, 'ADOBE Illustrator Creative Cloud', 3225.25, 'godišnja licenca', 'https://www.links.hr/content/images/thumbs/000/0007635_adobe-illustrator-creative-cloud-godisnja-preplata-licenca-elektronski-proizvod-250125083.jpg'),
(5, 'Antivirus McAfee Plus', 84.55, 'godišnja licenca', 'https://www.links.hr/content/images/thumbs/000/0007598_antivirus-mcafee-plus-service-activation-code-card-1-year-eng-250120057.jpg'),
(5, 'BITDEFENDER Antivirus Plus 2016', 137.75, 'godišnja licenca', 'https://www.links.hr/content/images/thumbs/001/0010197_bitdefender-antivirus-plus-2016-1usr-retail-250120097.jpg'),
(5, 'MICROSOFT Office 2016 Home and Business', 1804.05, 'na hrvatskom, bez medija', 'https://www.links.hr/content/images/thumbs/001/0010171_microsoft-office-2016-home-and-business-hrvatski-bez-medija-t5d-02479.jpeg')

go

create proc getAllKategorije
as
begin
	select * from Kategorija
end

go

create proc getAllProizvodi
	@idKategorija int
as
begin
	select * from Proizvod
	where IDKategorija = @idKategorija
end

go

create proc updateProizvod
	@proizvodId int,
	@Naziv nvarchar(50),
	@Cijena money,
	@Slika nvarchar(200),
	@Opis nvarchar(50)
as
begin
	update Proizvod
	set
	Naziv = @Naziv,
	Cijena = @Cijena,
	Slika = @Slika, 
	Opis = @Opis
	where ProizvodId = @proizvodId
end

go

create proc insertProizvod
	@proizvodId int out,
	@IdKategorija int,
	@Naziv nvarchar(50),
	@Cijena money,
	@Slika nvarchar(200),
	@Opis nvarchar(50)
as
begin
	insert into Proizvod(IdKategorija, Naziv, Cijena, Slika, Opis)
	values
	(@IdKategorija, @Naziv, @Cijena, @Slika, @Opis)
	Set @proizvodId = scope_identity()
end

go

--KORISNICI

create table Korisnik
(
	KorisnikId int constraint pk_Korisnik primary key identity,
	KorisnickoIme nvarchar(50) unique not null,
	Lozinka nvarchar(50) not null,
	Administrator bit not null
)

create table NacinKupnje
(
	NacinKupnjeId int constraint pk_NacinKupnje primary key identity,
	Naziv nvarchar(50) not null
)

create table Transakcija
(
	TransakcijaId int constraint pk_Transakcija primary key identity,
	IdKorisnik int constraint fk_Transakcija_Korisnik foreign key references Korisnik(KorisnikId) not null,
	IdProizvod int constraint fk_Transakcija_Proizvod foreign key references Proizvod(ProizvodId) not null,
	IdNacinKupnje int constraint fk_Transakcija_NacinKupnje foreign key references NacinKupnje(NacinKupnjeId) not null,
	Kolicina int not null,
	DatumKupnje datetime not null
)

insert into NacinKupnje(Naziv)
values
('Gotovina'),
('PayPal')

insert into Korisnik(KorisnickoIme, Lozinka, Administrator)
values 
('Pero', '123', 0),
('Ana', '123', 0),
('Jura', '123', 1)

go

create proc getAllUser
as
begin
	select * from Korisnik
end

go

create proc getUserForId
	@id int
as
begin
	select * 
	from Korisnik
	where KorisnikId = @id
end

go

create proc getUser
	@username nvarchar(50),
	@password nvarchar(50)
as
begin
	select * 
	from Korisnik
	where KorisnickoIme = @username and Lozinka = @password
end

go

create proc isAdmin
	@username nvarchar(50),
	@isAdmin bit output
as
begin
	select @isAdmin = Administrator
	from Korisnik
	where KorisnickoIme = @username	
end

go

create proc createUser
	@username nvarchar(50),
	@password nvarchar(50),
	@isAdmin bit output
as
begin
	insert into Korisnik(KorisnickoIme, Lozinka, Administrator)
	values 
	(@username, @password, @isAdmin)
end

go

create proc getTransakcije
	@idKorisnik int
as
begin
	select 
	t.Kolicina as Kolicina,
	t.DatumKupnje as DatumKupnje,
	p.Naziv as Proizvod,
	p.ProizvodId as ProizvodId,
	p.Cijena as CijenaPojedinacna,
	n.Naziv as TipPlacanja
	from Transakcija as t
	inner join Proizvod as p
	on t.IdProizvod = p.ProizvodId
	inner join NacinKupnje as n
	on t.IdNacinKupnje = n.NacinKupnjeId
	where t.IdKorisnik = @idKorisnik
	order by t.DatumKupnje desc
end

go

create proc getTransakcijeOdDo
	@idKorisnik int,
	@datumOd datetime,
	@datumDo datetime
as
begin
	select 
	t.Kolicina as Kolicina,
	t.DatumKupnje as DatumKupnje,
	p.Naziv as Proizvod,
	p.ProizvodId as ProizvodId,
	p.Cijena as CijenaPojedinacna,
	n.Naziv as TipPlacanja
	from Transakcija as t
	inner join Proizvod as p
	on t.IdProizvod = p.ProizvodId
	inner join NacinKupnje as n
	on t.IdNacinKupnje = n.NacinKupnjeId
	where (t.IdKorisnik = @idKorisnik) and (t.DatumKupnje between @datumOd and @datumDo)
	order by t.DatumKupnje desc
end

go

create proc insertTransakcije
	@idKorisnik int,
	@idProizvod int,
	@idNacinKupnje int,
	@kolicina int, 
	@datumKupnje nvarchar(50)

as
begin
	insert into Transakcija (IdKorisnik, IdProizvod, IdNacinKupnje, Kolicina, DatumKupnje)
	values
	(@idKorisnik, @idProizvod, @idNacinKupnje, @kolicina, @datumKupnje)
end

go

--ADMIN STVARI

create table PristupStranicama
(
	PristupId int constraint pk_PristupStranicama primary key identity,
	IdKorisnik int constraint fk_PristupStranicama_Korisnik foreign key references Korisnik(KorisnikId), --moze biti null jer anon korisnici nemaju pk
	IpAdresa varchar(50) not null,
	Stranica nvarchar(50) not null,
	Datum datetime not null
)

create table Prijave
(
	UlogiravanjeId int constraint pk_Ulogiravanje primary key identity,
	IdKorisnik int constraint fk_Ulogiravanje_Korisnik foreign key references Korisnik(KorisnikId) not null,
	IpAdresa varchar(50) not null,
	Datum datetime not null
)

go

create proc getAllPristupStranicama
	@amount int
as
begin
	select top (@amount) * from PristupStranicama as ps
	left join Korisnik as k
	on ps.IdKorisnik = k.KorisnikId
	order by Datum desc
end

go

create proc getPristupStranicamaForKorisnik
	@korisnikId int
as
begin
	select * from PristupStranicama as ps
	left join Korisnik as k
	on ps.IdKorisnik = k.KorisnikId
	where k.KorisnikId = @korisnikId
	order by Datum desc
end

go

create proc getPristupStranicamaForKorisnikOdDo
	@korisnikId int,
	@datumOd datetime,
	@datumDo datetime
as
begin
	select * from PristupStranicama as ps
	left join Korisnik as k
	on ps.IdKorisnik = k.KorisnikId
	where (IdKorisnik = @korisnikId) and (ps.Datum between @datumOd and @datumDo)
	order by Datum desc
end

go

create proc insertPristup
	@idKorisnik int,
	@ipAdresa varchar(15),
	@stranica nvarchar(50),
	@datum nvarchar(50)
as
begin
	insert into PristupStranicama (IdKorisnik, IpAdresa, Stranica, Datum)
	values
	(@idKorisnik, @ipAdresa, @stranica, @datum)
end

go

create proc getPrijave
	@korisnikId int
as
begin
	select * from Prijave as p
	inner join Korisnik as k
	on p.IdKorisnik = k.KorisnikId
	where IdKorisnik = @korisnikId
	order by p.Datum desc
end

go

create proc getPrijaveOdDo
	@korisnikId int,
	@datumOd datetime,
	@datumDo datetime
as
begin
	select * from Prijave as p
	inner join Korisnik as k
	on p.IdKorisnik = k.KorisnikId
	where (IdKorisnik = @korisnikId) and (p.Datum between @datumOd and @datumDo)
	order by p.Datum desc
end

go

create proc insertPrijave
	@idKorisnik int,
	@ipAdresa varchar(15),
	@datum nvarchar(50)
as
begin
	insert into Prijave(IdKorisnik, IpAdresa, Datum)
	values
	(@idKorisnik, @ipAdresa, @datum)
end

--select * from Korisnik
--delete Transakcija where IdKorisnik = 8
--delete PristupStranicama where IdKorisnik = 8
--delete Prijave where IdKorisnik = 8
--delete Korisnik where KorisnikId = 8