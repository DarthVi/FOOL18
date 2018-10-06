push 0
push 3
push 5
push 2
push classpaperino
new
push 1
push 1
push classpippo
new
lfp
push -2
lfp
add
lw
copy
lw
push 2
add
lc
js
halt

function0:
cfp
lra
push 2
srv
sra
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 2
push 0
lfp
add
lw
calchoff
add
lw
add
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 2
srv
sra
pop
pop
sfp
lrv
lra
js
classpippo:
function0
function1
classpaperino:
function1
function2
function3
