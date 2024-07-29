PGDMP                         |            envios    15.4    15.4 0    >           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            @           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            A           1262    254332    envios    DATABASE     y   CREATE DATABASE envios WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE envios;
                postgres    false            �            1259    254396 	   empleados    TABLE     6  CREATE TABLE public.empleados (
    ci character varying(10) NOT NULL,
    nombres character varying(64),
    apellidos character varying(64),
    direccion character varying(128),
    fecha_nacimiento character varying(10),
    sexo character varying(10),
    telefono_convencional character varying(10),
    telefono_movil character varying(10),
    correo_electronico character varying(64),
    cargo character varying(32),
    estadoempleado character varying(12) DEFAULT 'Activo'::character varying,
    CONSTRAINT empleados_estadoempleado_check CHECK (((estadoempleado)::text = ANY ((ARRAY['Activo'::character varying, 'Dado de baja'::character varying])::text[]))),
    CONSTRAINT empleados_sexo_check CHECK (((sexo)::text = ANY ((ARRAY['Masculino'::character varying, 'Femenino'::character varying])::text[])))
);
    DROP TABLE public.empleados;
       public         heap    postgres    false            �            1259    262563 	   incidente    TABLE     �  CREATE TABLE public.incidente (
    idincidente integer NOT NULL,
    idpaquete integer,
    tipoincidente character varying(40),
    descripcion text,
    CONSTRAINT incidente_tipoincidente_check CHECK (((tipoincidente)::text = ANY ((ARRAY['Daño en el Paquete'::character varying, 'Error de Dirección'::character varying, 'Paquete Perdido'::character varying, 'Rechazo Entrega'::character varying])::text[])))
);
    DROP TABLE public.incidente;
       public         heap    postgres    false            �            1259    262562    incidente_idincidente_seq    SEQUENCE     �   CREATE SEQUENCE public.incidente_idincidente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.incidente_idincidente_seq;
       public          postgres    false    224            B           0    0    incidente_idincidente_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.incidente_idincidente_seq OWNED BY public.incidente.idincidente;
          public          postgres    false    223            �            1259    262536 
   inventario    TABLE     �   CREATE TABLE public.inventario (
    idinventario integer NOT NULL,
    descripcion text,
    fechaingreso timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.inventario;
       public         heap    postgres    false            �            1259    262535    inventario_idinventario_seq    SEQUENCE     �   CREATE SEQUENCE public.inventario_idinventario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.inventario_idinventario_seq;
       public          postgres    false    220            C           0    0    inventario_idinventario_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.inventario_idinventario_seq OWNED BY public.inventario.idinventario;
          public          postgres    false    219            �            1259    262546    inventario_paquete    TABLE     �   CREATE TABLE public.inventario_paquete (
    idinventariopaquete integer NOT NULL,
    codigotraking integer,
    idpaquete integer
);
 &   DROP TABLE public.inventario_paquete;
       public         heap    postgres    false            �            1259    262545 *   inventario_paquete_idinventariopaquete_seq    SEQUENCE     �   CREATE SEQUENCE public.inventario_paquete_idinventariopaquete_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.inventario_paquete_idinventariopaquete_seq;
       public          postgres    false    222            D           0    0 *   inventario_paquete_idinventariopaquete_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.inventario_paquete_idinventariopaquete_seq OWNED BY public.inventario_paquete.idinventariopaquete;
          public          postgres    false    221            �            1259    262525    paquete    TABLE       CREATE TABLE public.paquete (
    idpaquete integer NOT NULL,
    peso numeric(16,2),
    ancho numeric(16,2),
    largo numeric(16,2),
    contenido text,
    remitente character varying(100),
    direcciondestino character varying(255),
    estado character varying(20),
    fechaenvio timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT paquete_estado_check CHECK (((estado)::text = ANY ((ARRAY['Pendiente'::character varying, 'EnCurso'::character varying, 'Entregado'::character varying])::text[])))
);
    DROP TABLE public.paquete;
       public         heap    postgres    false            �            1259    262524    paquete_idpaquete_seq    SEQUENCE     �   CREATE SEQUENCE public.paquete_idpaquete_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.paquete_idpaquete_seq;
       public          postgres    false    218            E           0    0    paquete_idpaquete_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.paquete_idpaquete_seq OWNED BY public.paquete.idpaquete;
          public          postgres    false    217            �            1259    254422    usuarios    TABLE     �  CREATE TABLE public.usuarios (
    idusuario integer NOT NULL,
    nombreuser character varying(28),
    ci character varying(10),
    passwordu character varying(32),
    numpregunta integer,
    respuesta character varying(32),
    rol character varying(13),
    estado character varying(13) DEFAULT 'Activado'::character varying NOT NULL,
    CONSTRAINT usuarios_estado_check CHECK (((estado)::text = ANY ((ARRAY['Activado'::character varying, 'Bloqueado'::character varying])::text[]))),
    CONSTRAINT usuarios_rol_check CHECK (((rol)::text = ANY ((ARRAY['Administrador'::character varying, 'Recepcionista'::character varying, 'Conductor'::character varying])::text[])))
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    254421    usuarios_idusuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuarios_idusuario_seq;
       public          postgres    false    216            F           0    0    usuarios_idusuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuarios_idusuario_seq OWNED BY public.usuarios.idusuario;
          public          postgres    false    215            �            1259    262578    vistadatospaquete    VIEW       CREATE VIEW public.vistadatospaquete AS
 SELECT p.idpaquete,
    p.contenido,
    p.remitente,
    p.direcciondestino,
    p.fechaenvio,
    p.estado,
    ip.codigotraking
   FROM (public.paquete p
     JOIN public.inventario_paquete ip ON ((p.idpaquete = ip.idpaquete)));
 $   DROP VIEW public.vistadatospaquete;
       public          postgres    false    222    218    218    222    218    218    218    218            �           2604    262566    incidente idincidente    DEFAULT     ~   ALTER TABLE ONLY public.incidente ALTER COLUMN idincidente SET DEFAULT nextval('public.incidente_idincidente_seq'::regclass);
 D   ALTER TABLE public.incidente ALTER COLUMN idincidente DROP DEFAULT;
       public          postgres    false    224    223    224            �           2604    262539    inventario idinventario    DEFAULT     �   ALTER TABLE ONLY public.inventario ALTER COLUMN idinventario SET DEFAULT nextval('public.inventario_idinventario_seq'::regclass);
 F   ALTER TABLE public.inventario ALTER COLUMN idinventario DROP DEFAULT;
       public          postgres    false    220    219    220            �           2604    262549 &   inventario_paquete idinventariopaquete    DEFAULT     �   ALTER TABLE ONLY public.inventario_paquete ALTER COLUMN idinventariopaquete SET DEFAULT nextval('public.inventario_paquete_idinventariopaquete_seq'::regclass);
 U   ALTER TABLE public.inventario_paquete ALTER COLUMN idinventariopaquete DROP DEFAULT;
       public          postgres    false    222    221    222            �           2604    262528    paquete idpaquete    DEFAULT     v   ALTER TABLE ONLY public.paquete ALTER COLUMN idpaquete SET DEFAULT nextval('public.paquete_idpaquete_seq'::regclass);
 @   ALTER TABLE public.paquete ALTER COLUMN idpaquete DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    254425    usuarios idusuario    DEFAULT     x   ALTER TABLE ONLY public.usuarios ALTER COLUMN idusuario SET DEFAULT nextval('public.usuarios_idusuario_seq'::regclass);
 A   ALTER TABLE public.usuarios ALTER COLUMN idusuario DROP DEFAULT;
       public          postgres    false    216    215    216            1          0    254396 	   empleados 
   TABLE DATA           �   COPY public.empleados (ci, nombres, apellidos, direccion, fecha_nacimiento, sexo, telefono_convencional, telefono_movil, correo_electronico, cargo, estadoempleado) FROM stdin;
    public          postgres    false    214   HA       ;          0    262563 	   incidente 
   TABLE DATA           W   COPY public.incidente (idincidente, idpaquete, tipoincidente, descripcion) FROM stdin;
    public          postgres    false    224   �A       7          0    262536 
   inventario 
   TABLE DATA           M   COPY public.inventario (idinventario, descripcion, fechaingreso) FROM stdin;
    public          postgres    false    220   (B       9          0    262546    inventario_paquete 
   TABLE DATA           [   COPY public.inventario_paquete (idinventariopaquete, codigotraking, idpaquete) FROM stdin;
    public          postgres    false    222   �B       5          0    262525    paquete 
   TABLE DATA           |   COPY public.paquete (idpaquete, peso, ancho, largo, contenido, remitente, direcciondestino, estado, fechaenvio) FROM stdin;
    public          postgres    false    218   �B       3          0    254422    usuarios 
   TABLE DATA           m   COPY public.usuarios (idusuario, nombreuser, ci, passwordu, numpregunta, respuesta, rol, estado) FROM stdin;
    public          postgres    false    216   �C       G           0    0    incidente_idincidente_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.incidente_idincidente_seq', 2, true);
          public          postgres    false    223            H           0    0    inventario_idinventario_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.inventario_idinventario_seq', 7, true);
          public          postgres    false    219            I           0    0 *   inventario_paquete_idinventariopaquete_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.inventario_paquete_idinventariopaquete_seq', 7, true);
          public          postgres    false    221            J           0    0    paquete_idpaquete_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.paquete_idpaquete_seq', 1, false);
          public          postgres    false    217            K           0    0    usuarios_idusuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuarios_idusuario_seq', 1, true);
          public          postgres    false    215            �           2606    254403    empleados empleados_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_pkey PRIMARY KEY (ci);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_pkey;
       public            postgres    false    214            �           2606    262571    incidente incidente_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.incidente
    ADD CONSTRAINT incidente_pkey PRIMARY KEY (idincidente);
 B   ALTER TABLE ONLY public.incidente DROP CONSTRAINT incidente_pkey;
       public            postgres    false    224            �           2606    262551 *   inventario_paquete inventario_paquete_pkey 
   CONSTRAINT     y   ALTER TABLE ONLY public.inventario_paquete
    ADD CONSTRAINT inventario_paquete_pkey PRIMARY KEY (idinventariopaquete);
 T   ALTER TABLE ONLY public.inventario_paquete DROP CONSTRAINT inventario_paquete_pkey;
       public            postgres    false    222            �           2606    262544    inventario inventario_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.inventario
    ADD CONSTRAINT inventario_pkey PRIMARY KEY (idinventario);
 D   ALTER TABLE ONLY public.inventario DROP CONSTRAINT inventario_pkey;
       public            postgres    false    220            �           2606    262534    paquete paquete_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.paquete
    ADD CONSTRAINT paquete_pkey PRIMARY KEY (idpaquete);
 >   ALTER TABLE ONLY public.paquete DROP CONSTRAINT paquete_pkey;
       public            postgres    false    218            �           2606    254432     usuarios usuarios_nombreuser_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_nombreuser_key UNIQUE (nombreuser);
 J   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_nombreuser_key;
       public            postgres    false    216            �           2606    254430    usuarios usuarios_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (idusuario);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    216            �           2606    262572 "   incidente incidente_idpaquete_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidente
    ADD CONSTRAINT incidente_idpaquete_fkey FOREIGN KEY (idpaquete) REFERENCES public.paquete(idpaquete);
 L   ALTER TABLE ONLY public.incidente DROP CONSTRAINT incidente_idpaquete_fkey;
       public          postgres    false    218    3223    224            �           2606    262552 8   inventario_paquete inventario_paquete_codigotraking_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventario_paquete
    ADD CONSTRAINT inventario_paquete_codigotraking_fkey FOREIGN KEY (codigotraking) REFERENCES public.inventario(idinventario);
 b   ALTER TABLE ONLY public.inventario_paquete DROP CONSTRAINT inventario_paquete_codigotraking_fkey;
       public          postgres    false    222    220    3225            �           2606    262557 4   inventario_paquete inventario_paquete_idpaquete_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.inventario_paquete
    ADD CONSTRAINT inventario_paquete_idpaquete_fkey FOREIGN KEY (idpaquete) REFERENCES public.paquete(idpaquete);
 ^   ALTER TABLE ONLY public.inventario_paquete DROP CONSTRAINT inventario_paquete_idpaquete_fkey;
       public          postgres    false    222    218    3223            �           2606    254433    usuarios usuarios_ci_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_ci_fkey FOREIGN KEY (ci) REFERENCES public.empleados(ci);
 C   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_ci_fkey;
       public          postgres    false    214    216    3217            1   �   x�]�A� E��)� �Dag��	���Ɛ�NR���[n�����7�%�1��&���2��Y�*�;z�
�|�=�)�k!R��{�ЩVÃr�)���i-�O^g��ޏs.�o��B15�z�B�/C#�� (/V      ;   5   x�3�4�JM�H��Wp�+)JMO�t�Q(H,,M-IU(NUHI<�1�+F��� K�j      7   m   x���!�0P�"hd�qj�;�D*)��H;�&��?I	���/���C{���!m�9f���1�1�e �����0�󵞯�����Y��z��Y@����^����F      9   -   x�ȱ  ��?wq,��s�F�J��r�hvlF�9��ؼ|���      5   �   x�}�MJ1��u�u '$��韵��fܺ)�%Db2$�
��"���wW��Xp����k�2��R}	[.!���	)���w����&>Ϙ؇�8�"i�62t<��@=������;fTF۾��W���r�ۢO�{HxoR9J�����)2�a�cN/��8=LSGVuME�;y��_���K��-?D����Ͷ�n$7��I+�>�U\m      3   6   x�3�LL����,.)JL�/�4�NC#cNCN�̜|NG5��%�e@W� ��H     