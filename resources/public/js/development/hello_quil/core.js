// Compiled by ClojureScript 1.10.439 {}
goog.provide('hello_quil.core');
goog.require('cljs.core');
goog.require('quil.core');
goog.require('quil.middleware');
hello_quil.core.setup = (function hello_quil$core$setup(){
quil.core.frame_rate.call(null,(30));

quil.core.color_mode.call(null,new cljs.core.Keyword(null,"hsb","hsb",-753472031));

return new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"color","color",1011675173),(0),new cljs.core.Keyword(null,"angle","angle",1622094254),(0)], null);
});
hello_quil.core.update_state = (function hello_quil$core$update_state(state){
return new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"color","color",1011675173),cljs.core.mod.call(null,(new cljs.core.Keyword(null,"color","color",1011675173).cljs$core$IFn$_invoke$arity$1(state) + 0.7),(255)),new cljs.core.Keyword(null,"angle","angle",1622094254),(new cljs.core.Keyword(null,"angle","angle",1622094254).cljs$core$IFn$_invoke$arity$1(state) + 0.1)], null);
});
hello_quil.core.draw_state = (function hello_quil$core$draw_state(state){
quil.core.background.call(null,(240));

quil.core.fill.call(null,new cljs.core.Keyword(null,"color","color",1011675173).cljs$core$IFn$_invoke$arity$1(state),(255),(255));

var angle = new cljs.core.Keyword(null,"angle","angle",1622094254).cljs$core$IFn$_invoke$arity$1(state);
var x = ((150) * quil.core.cos.call(null,angle));
var y = ((150) * quil.core.sin.call(null,angle));
var tr__2235__auto__ = new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(quil.core.width.call(null) / (2)),(quil.core.height.call(null) / (2))], null);
quil.core.push_matrix.call(null);

try{quil.core.translate.call(null,tr__2235__auto__);

return quil.core.ellipse.call(null,x,y,(100),(100));
}finally {quil.core.pop_matrix.call(null);
}});
hello_quil.core.run_sketch = (function hello_quil$core$run_sketch(){
hello_quil.core.hello_quil = (function hello_quil$core$run_sketch_$_hello_quil(){
return quil.sketch.sketch.call(null,new cljs.core.Keyword(null,"host","host",-1558485167),"hello-quil",new cljs.core.Keyword(null,"update","update",1045576396),((cljs.core.fn_QMARK_.call(null,hello_quil.core.update_state))?(function() { 
var G__2347__delegate = function (args){
return cljs.core.apply.call(null,hello_quil.core.update_state,args);
};
var G__2347 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__2348__i = 0, G__2348__a = new Array(arguments.length -  0);
while (G__2348__i < G__2348__a.length) {G__2348__a[G__2348__i] = arguments[G__2348__i + 0]; ++G__2348__i;}
  args = new cljs.core.IndexedSeq(G__2348__a,0,null);
} 
return G__2347__delegate.call(this,args);};
G__2347.cljs$lang$maxFixedArity = 0;
G__2347.cljs$lang$applyTo = (function (arglist__2349){
var args = cljs.core.seq(arglist__2349);
return G__2347__delegate(args);
});
G__2347.cljs$core$IFn$_invoke$arity$variadic = G__2347__delegate;
return G__2347;
})()
:hello_quil.core.update_state),new cljs.core.Keyword(null,"size","size",1098693007),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [(500),(500)], null),new cljs.core.Keyword(null,"setup","setup",1987730512),((cljs.core.fn_QMARK_.call(null,hello_quil.core.setup))?(function() { 
var G__2350__delegate = function (args){
return cljs.core.apply.call(null,hello_quil.core.setup,args);
};
var G__2350 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__2351__i = 0, G__2351__a = new Array(arguments.length -  0);
while (G__2351__i < G__2351__a.length) {G__2351__a[G__2351__i] = arguments[G__2351__i + 0]; ++G__2351__i;}
  args = new cljs.core.IndexedSeq(G__2351__a,0,null);
} 
return G__2350__delegate.call(this,args);};
G__2350.cljs$lang$maxFixedArity = 0;
G__2350.cljs$lang$applyTo = (function (arglist__2352){
var args = cljs.core.seq(arglist__2352);
return G__2350__delegate(args);
});
G__2350.cljs$core$IFn$_invoke$arity$variadic = G__2350__delegate;
return G__2350;
})()
:hello_quil.core.setup),new cljs.core.Keyword(null,"middleware","middleware",1462115504),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [quil.middleware.fun_mode], null),new cljs.core.Keyword(null,"draw","draw",1358331674),((cljs.core.fn_QMARK_.call(null,hello_quil.core.draw_state))?(function() { 
var G__2353__delegate = function (args){
return cljs.core.apply.call(null,hello_quil.core.draw_state,args);
};
var G__2353 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__2354__i = 0, G__2354__a = new Array(arguments.length -  0);
while (G__2354__i < G__2354__a.length) {G__2354__a[G__2354__i] = arguments[G__2354__i + 0]; ++G__2354__i;}
  args = new cljs.core.IndexedSeq(G__2354__a,0,null);
} 
return G__2353__delegate.call(this,args);};
G__2353.cljs$lang$maxFixedArity = 0;
G__2353.cljs$lang$applyTo = (function (arglist__2355){
var args = cljs.core.seq(arglist__2355);
return G__2353__delegate(args);
});
G__2353.cljs$core$IFn$_invoke$arity$variadic = G__2353__delegate;
return G__2353;
})()
:hello_quil.core.draw_state));
});
goog.exportSymbol('hello_quil.core.hello_quil', hello_quil.core.hello_quil);

if(cljs.core.truth_(cljs.core.some.call(null,(function (p1__1400__1401__auto__){
return cljs.core._EQ_.call(null,new cljs.core.Keyword(null,"no-start","no-start",1381488856),p1__1400__1401__auto__);
}),null))){
return null;
} else {
return quil.sketch.add_sketch_to_init_list.call(null,new cljs.core.PersistentArrayMap(null, 2, [new cljs.core.Keyword(null,"fn","fn",-1175266204),hello_quil.core.hello_quil,new cljs.core.Keyword(null,"host-id","host-id",742376279),"hello-quil"], null));
}
});
goog.exportSymbol('hello_quil.core.run_sketch', hello_quil.core.run_sketch);

//# sourceMappingURL=core.js.map
