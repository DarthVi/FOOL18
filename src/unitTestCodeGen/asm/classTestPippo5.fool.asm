push 0
push 0
push classpluto
new
push 20
push 5
push 2
push classpippo
new
lfp
push 10
push -2
lfp
add
lw
copy
lw
push 1
add
lc
js
halt

function0:
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
push 2
push 0
lfp
add
lw
calchoff
add
lw
div
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
mult
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
sub
srv
sra
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 12
srv
sra
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 2
push 3
push 1
push 10
push 20
push 2
push classpippo
new
push 0
push classpluto
new
lfp
push -5
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
push -6
lfp
add
lw
copy
lw
push 0
add
lc
js
add
srv
pop
pop
pop
pop
pop
sra
pop
pop
sfp
lrv
lra
js
classpluto:
function4
function5
classpippo:
function0
function1
function2
function3
classnull:
