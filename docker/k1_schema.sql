-- public.kpopgroup definition

-- Drop table

-- DROP TABLE public.kpopgroup;

CREATE TABLE public.kpopgroup (
	id int NOT NULL GENERATED ALWAYS AS IDENTITY,
	name varchar(40) NOT NULL,
	nickname varchar(20) NULL,
	numberofmembers int NOT NULL,
	company varchar(30) NOT NULL
);
